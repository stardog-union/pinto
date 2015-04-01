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

package com.complexible.pinto.codecs;

import com.complexible.common.openrdf.model.Graphs;
import com.complexible.common.openrdf.util.ResourceBuilder;
import com.complexible.pinto.RDFCodec;
import com.google.common.base.Optional;
import org.openrdf.model.Graph;
import org.openrdf.model.Resource;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.model.impl.ValueFactoryImpl;

import java.util.UUID;

/**
 * <p>Codec for (de)serializing {@link UUID}.</p>
 *
 * @author  Michael Grove
 * @since   1.0
 * @version 1.0
 */
public enum UUIDCodec implements RDFCodec<UUID> {
	Instance;

	public static final URI TYPE = ValueFactoryImpl.getInstance().createURI("tag:java.util.UUID");
	public static final URI PROPERTY = ValueFactoryImpl.getInstance().createURI("tag:java.util.UUID:uuid");

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResourceBuilder writeValue(final UUID theValue) {
		return new ResourceBuilder(ValueFactoryImpl.getInstance().createBNode())
				.addType(TYPE)
				.addProperty(PROPERTY, ValueFactoryImpl.getInstance().createLiteral(theValue.toString()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UUID readValue(final Graph theGraph, final Resource theObj) {
		final Optional<Value> aObject = Graphs.getObject(theGraph, theObj, PROPERTY);

		if (aObject.isPresent()) {
			return UUID.fromString(aObject.get().stringValue());
		}

		return null;
	}
}
