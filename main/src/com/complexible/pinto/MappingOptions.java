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

import com.complexible.common.base.Option;
import com.complexible.common.base.Options;

/**
 * <p></p>
 *
 * @author  Michael Grove
 * @since   1.0
 * @version 1.0
 */
public final class MappingOptions {
	private MappingOptions() {
		throw new AssertionError();
	}

	public static final Options DEFAULTS = Options.unmodifiable(Options.empty());

	// r/w ?
	public static final Option<Boolean> REQUIRE_IDS = Option.create("require.ids", false);

	// read options

	// write options
	public static final Option<Boolean> SERIALIZE_COLLECTIONS_AS_LISTS = Option.create("serialize.collections.as.lists", false);
	public static final Option<Boolean> IGNORE_INVALID_ANNOTATIONS = Option.create("ignore.invalid.annotations", true);
}
