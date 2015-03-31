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

import com.complexible.common.collect.Iterables2;
import com.google.common.base.Predicates;

import static com.google.common.collect.Iterables.any;

/**
 * <p></p>
 *
 * @author  Michael Grove
 * @version 1.0
 * @since   1.0
 */
public final class Classes {

	private Classes() {
		throw new AssertionError();
	}

	public static boolean _implements(final Class<?> theClass, final Class<?> theInterface) {
		return any(interfaces(theClass), Predicates.<Class<?>>equalTo(theInterface));
	}

	public static Iterable<Class<?>> interfaces(final Class<?> theClass) {
		return Iterables2.forArray(theClass.getInterfaces());
	}

	public static boolean isInstantiable(final Class<?> theClass) {
		return !theClass.isInterface() && !Modifier.isAbstract(theClass.getModifiers());
	}

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
