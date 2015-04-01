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

import org.openrdf.model.Resource;

/**
 * <p>Marker interface for something which has an rdf:ID associated with it</p>
 *
 * @author  Michael Grove
 * @since   1.0
 * @version 1.0
 */
public interface Identifiable {

	/**
	 * Return the rdf:ID of this instance
	 *
	 * @return  the id
	 */
	public Resource id();

	/**
	 * Set the rdf:ID of this instance
	 *
	 * @param theResource   the id
	 */
	public void id(final Resource theResource);
}
