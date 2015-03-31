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

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * <p></p>
 *
 * @author  Michael Grove
 * @version 1.0
 * @since   1.0
 */
public final class Methods {

	private Methods() {
		throw new AssertionError();
	}

	public static Predicate<Method> annotated(final Class<? extends Annotation> theAnnotation) {
		return new Predicate<Method>() {
			@Override
			public boolean apply(final Method theInput) {
				return theInput != null && theInput.getAnnotation(theAnnotation) != null;
			}
		};
	}

	public static Function<Method, String> property() {
		return new Function<Method, String>() {
			@Override
			public String apply(final Method input) {
				int aLen = 0;
				if (input.getName().startsWith("is")) {
					aLen = 2;
				}
				else if (input.getName().startsWith("get") || input.getName().startsWith("set")) {
					aLen = 3;
				}

				return Introspector.decapitalize(input.getName().substring(aLen));
			}
		};
	}
}
