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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.google.common.base.Predicate;

/**
 * <p>Utility for working with Fields via Java reflect</p>
 *
 * @author  Michael Grove
 * @version 1.0
 * @since   1.0
 */
public final class Fields {

	private Fields() {
		throw new AssertionError();
	}

	/**
	 * Predicate that will return whether or not a field has the given anotation
	 *
	 * @param theAnnotation the annotation
	 * @return              a predicate that will check a field for the annotation
	 */
	public static Predicate<Field> annotated(final Class<? extends Annotation> theAnnotation) {
		return new Predicate<Field>() {
			@Override
			public boolean apply(final Field theInput) {
				return theInput.getAnnotation(theAnnotation) != null;
			}
		};
	}
}
