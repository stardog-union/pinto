/*
 * Copyright (c) 2015 Complexible Inc. <http://complexible.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.complexible.common.beans;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;

import com.google.common.collect.AbstractIterator;

/**
 * <p>Utility class for working with Java beans</p>
 *
 * @author  Michael Grove
 * @version 1.0
 * @since   1.0
 */
public final class Beans {

	private Beans() {
		throw new AssertionError();
	}

	/**
	 * Return whether or not the given object is a Java primitive type (String is included as a primitive).
	 *
	 * @param theObj the object
	 *
	 * @return true if its a primitive, false otherwise.
	 */
	public static boolean isPrimitive(Object theObj) {
		return (Boolean.class.isInstance(theObj) || Integer.class.isInstance(theObj) || Long.class.isInstance(theObj)
		        || Short.class.isInstance(theObj) || Double.class.isInstance(theObj) || Float.class.isInstance(theObj)
		        || Date.class.isInstance(theObj) || String.class.isInstance(theObj) || Character.class.isInstance(theObj)
		        || java.net.URI.class.isInstance(theObj));
	}

	/**
	 * Return whether or not the given class represents a Java primitive type (String is included as a primitive).
	 *
	 * @param theObj the object
	 *
	 * @return true if its a primitive, false otherwise.
	 */
	public static boolean isPrimitive(Class theObj) {
		return (Boolean.class.equals(theObj) || Integer.class.equals(theObj) || Long.class.equals(theObj)
		        || Short.class.equals(theObj) || Double.class.equals(theObj) || Float.class.equals(theObj)
		        || Date.class.equals(theObj) || String.class.equals(theObj) || Character.class.equals(theObj)
		        || java.net.URI.class.equals(theObj));
	}

	/**
	 * Return an {@link Iterable} of the declared fields of the {@link Class}
	 *
	 * @param theClass  the class
	 * @return          the declared fields
	 */
	public static Iterable<Field> getDeclaredFields(final Class<?> theClass) {
		return new Iterable<Field>() {
			public Iterator<Field> iterator() {
				return new AbstractIterator<Field>() {
					private Class<?> mCurr = theClass;

					private Field[] mCurrFields = new Field[0];

					private int mIndex = 0;

					/**
					 * {@inheritDoc}
					 */
					@Override
					protected Field computeNext() {

						if (mIndex < mCurrFields.length) {
							return mCurrFields[mIndex++];
						}

						while (mIndex == mCurrFields.length && mCurr != null) {
							mCurrFields = mCurr.getDeclaredFields();
							mCurr = mCurr.getSuperclass();
							mIndex = 0;

							if (mIndex < mCurrFields.length) {
								return mCurrFields[mIndex++];
							}
						}

						return endOfData();
					}
				};
			}
		};
	}

	/**
	 * Return an {@link Iterable} of the declared methods of the {@link Class}
	 *
	 * @param theClass  the class
	 * @return          the declared methods
	 */
	public static Iterable<Method> getDeclaredMethods(final Class<?> theClass) {
		return new Iterable<Method>() {
			public Iterator<Method> iterator() {
				return new AbstractIterator<Method>() {
					private Class<?> mCurr = theClass;

					private Method[] mMethods = new Method[0];

					private int mIndex = 0;

					/**
					 * {@inheritDoc}
					 */
					@Override
					protected Method computeNext() {
						if (mIndex < mMethods.length) {
							return mMethods[mIndex++];
						}

						while (mIndex == mMethods.length && mCurr != null) {
							mMethods = mCurr.getDeclaredMethods();
							mCurr = mCurr.getSuperclass();
							mIndex = 0;

							if (mIndex < mMethods.length) {
								return mMethods[mIndex++];
							}
						}

						return endOfData();
					}
				};
			}
		};
	}
}
