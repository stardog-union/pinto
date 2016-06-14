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

import java.beans.Introspector;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>Utility for working with Methods via Java reflect</p>
 *
 * @author  Michael Grove
 * @version 1.0
 * @since   2.0
 */
public final class Methods {

	private Methods() {
		throw new AssertionError();
	}

	/**
	 * Predicate that will return whether or not a method has the given anotation
	 *
	 * @param theAnnotation the annotation
	 * @return              a predicate that will check a method for the annotation
	 */
	public static Predicate<Method> annotated(final Class<? extends Annotation> theAnnotation) {
		return theInput -> theInput != null && theInput.getAnnotation(theAnnotation) != null;
	}

	/**
	 * Function that will return the bean property name corresponding to the given method.
	 *
	 * @return  property name function
	 */
	public static Function<Method, String> property() {
		return input -> {
			int aLen = 0;
			if (input.getName().startsWith("is")) {
				aLen = 2;
			}
			else if (input.getName().startsWith("get") || input.getName().startsWith("set")) {
				aLen = 3;
			}

			return Introspector.decapitalize(input.getName().substring(aLen));
		};
	}
}
