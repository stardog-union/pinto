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

import com.complexible.common.openrdf.util.ResourceBuilder;
import org.openrdf.model.Graph;
import org.openrdf.model.Resource;

/**
 * <p></p>
 *
 * @author  Michael Grove
 * @since   1.0
 * @version 1.0
 */
public interface RDFCodec<T> {
	public ResourceBuilder writeValue(final T theValue);

	/**
	 * Deserialize the object denoted by the given resource from the graph into the original Java object
	 * @param theGraph  the graph
	 * @param theObj    the resource to deserialize
	 * @return          the object, or null if the data is incomplete
	 *
	 * @throws RDFMappingException if there is an error while deserializing
	 */
	public T readValue(final Graph theGraph, final Resource theObj);
}
