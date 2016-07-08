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

package com.complexible.common.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;

import static com.google.common.collect.Iterables.any;

/**
 * <p>Utility class for working with Class via Java reflect</p>
 *
 * @author  Michael Grove
 *
 * @since   1.0
 * @version 2.0
 */
public final class Classes {

	/**
	 * No instances
	 */
	private Classes() {
		throw new AssertionError();
	}

	/**
	 * Return whether or not the {@link Class} implements the given interface
	 *
	 * @param theClass      the class
	 * @param theInterface  the interface
	 * @return              true if it implements it, false otherwise
	 */
	public static boolean _implements(final Class<?> theClass, final Class<?> theInterface) {
		return any(interfaces(theClass), Predicates.<Class<?>>equalTo(theInterface));
	}

	/**
	 * Return all the interfaces of the {@link Class} as an {@link Iterable}
	 * @param theClass  the class
	 * @return          the interfaces of the class
	 */
	public static Iterable<Class<?>> interfaces(final Class<?> theClass) {
		return Lists.newArrayList(theClass.getInterfaces());
	}

	/**
	 * Return whether or not the {@link Class} is instantiable, ie not an interface and not abstract.
	 *
	 * @param theClass  the class
	 * @return          true if instantiable, false otherwise.
	 */
	public static boolean isInstantiable(final Class<?> theClass) {
		return !theClass.isInterface() && !Modifier.isAbstract(theClass.getModifiers());
	}

	/**
	 * Return whether or not the {@link Class} contains a default constructor
	 *
	 * @param theClass  the class
	 * @return          true if it has a default constructor, false otherwise
	 */
	public static boolean hasDefaultConstructor(final Class<?> theClass) {
		// rather than calling theClass.getConstructor() directly and incurring the overhead of creating
		// the NoSuchMethodException if the constructor is not present, we'll just scan through the constructors
		// there's only likely to be a few so hopefully this is a faster check.  TBD
		for (Constructor aConstructor : theClass.getConstructors()) {
			if (aConstructor.getParameterTypes().length == 0) {
				return true;
			}
		}

		return false;
	}
}
