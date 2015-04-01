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

package com.complexible.pinto;

/**
 * <p>General exception indicating there was an error while mapping a bean into RDF, or vice versa.</p>
 *
 * @author  Michael Grove
 * @since   1.0
 * @version 1.0
 *
 * @see RDFMapper
 */
public class RDFMappingException extends RuntimeException {
	public RDFMappingException(final Throwable theCause) {
		super(theCause);
	}

	public RDFMappingException(final String theMessage) {
		super(theMessage);
	}

	public RDFMappingException(final String theMessage, final Throwable theCause) {
		super(theMessage, theCause);
	}
}
