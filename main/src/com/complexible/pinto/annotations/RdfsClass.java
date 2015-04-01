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

package com.complexible.pinto.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Class annotation which can be used to specify the {@code rdf:type} of an instance</p>
 *
 * <p>Example:</p>
 *
 * {@code
 * @RdfsClass("foaf:Person")
 * public final class Person {
 * ...
 * }
 * }
 *
 * @author  Michael Grove
 * @since   1.0
 * @version 1.0
 */
@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RdfsClass {

	/**
	 * The URI value of the class this object will be typed as
	 * @return the URI (or qname) of the class
	 */
	public String value();
}
