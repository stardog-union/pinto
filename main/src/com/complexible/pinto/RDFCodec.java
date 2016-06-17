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

import org.openrdf.model.Model;
import org.openrdf.model.Value;

/**
 * <p>Interface for a codec which can (de)serialize an object.  Useful in situations where the instance does not
 * conform to the Java bean specification, or is a third-party class and you cannot apply annotations to customize
 * the RDF output.</p>
 *
 * <p>Codecs should be provided to the {@link RDFMapper.Builder#codec(Class, RDFCodec) mapper} when it's being created.</p>
 *
 * @author  Michael Grove
 * @since   1.0
 * @version 2.0
 */
public interface RDFCodec<T> {

	/**
	 * Serialize the given value as RDF.  This should produce a round-trippable serialization, that is, the output of
	 * this method should return an object that is {@code .equals} to the result of passing the result to
	 * {@link #readValue(Model, Value)}.
	 *
	 * @param theValue  the value to serialize
	 *
	 * @return          the value represented as RDF
	 */
	public Value writeValue(final T theValue);

	/**
	 * Deserialize the object denoted by the given resource from the graph into the original Java object
	 * @param theGraph  the graph
	 * @param theObj    the resource to deserialize
	 * @return          the object, or null if the data is incomplete
	 *
	 * @throws RDFMappingException if there is an error while deserializing
	 */
	public T readValue(final Model theGraph, final Value theObj);
}
