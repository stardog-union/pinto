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

package com.complexible.pinto.impl;

import com.complexible.pinto.SourcedObject;
import org.openrdf.model.Model;

/**
 * <p>Default implementation of {@link SourcedObject}</p>
 *
 * @author  Michael Grove
 * @since   1.0
 * @version 2.0
 */
public final class SourcedObjectImpl implements SourcedObject {
	private Model mGraph;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Model getSourceGraph() {
		return mGraph;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setSourceGraph(final Model theGraph) {
		mGraph = theGraph;
	}
}
