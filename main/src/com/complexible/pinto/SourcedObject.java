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

import com.google.common.annotations.Beta;
import org.openrdf.model.Model;

/**
 * <p>Marker interface for an object which was generated from RDF</p>
 *
 * @author  Michael Grove
 * @since   1.0
 * @version 2.0
 */
@Beta
public interface SourcedObject {

	/**
	 * Return the graph of RDF used to create the object
	 * @return  the graph
	 */
	public Model getSourceGraph();

	/**
	 * Set the graph of RDF used to create the object
	 * @param theGraph  the RDF
	 */
	public void setSourceGraph(final Model theGraph);
}
