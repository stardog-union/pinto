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
import com.complexible.pinto.annotations.RdfId;
import com.complexible.pinto.annotations.RdfProperty;

/**
 * <p>Set of options for controlling some aspects of mapping beans to RDF.</p>
 *
 * @author  Michael Grove
 * @since   1.0
 * @version 1.0.1
 *
 * @see RDFMapper.Builder#set(Option, Object)
 */
public final class MappingOptions {
	private MappingOptions() {
		throw new AssertionError();
	}

	/**
	 * The default set of mapping options
	 */
	public static final Options DEFAULTS = Options.unmodifiable(Options.empty());

	/**
	 * Pinto will auto-generate URIs for objects when {@link RdfId} is not specified.  By setting this option
	 * to `true` {@link RDFMapper the mapper} will not auto-generate URIs, they must be specified explicitly, otherwise
	 * {@link UnidentifiableObjectException} will be thrown.
	 *
	 * default: `false`
	 */
	public static final Option<Boolean> REQUIRE_IDS = Option.create("require.ids", false);

	/**
	 * When true, {@link Collection collections} are serialized as RDF lists.  Otherwise, they're serialized using
	 * {@link Collection#size} separate property assertions.
	 *
	 * default: `false`
	 */
	public static final Option<Boolean> SERIALIZE_COLLECTIONS_AS_LISTS = Option.create("serialize.collections.as.lists", false);

	/**
	 * Whether or not to ignore an annotation which is invalid, such as {@link RdfProperty} which defines a property with
	 * an invalid URI.  Properties with invalid/ignored annotations are simply not used when generating a Bean or RDF.
	 *
	 * default: `true`
	 */
	public static final Option<Boolean> IGNORE_INVALID_ANNOTATIONS = Option.create("ignore.invalid.annotations", true);

	/**
	 * Whether or not it should be considered a fatal error when the cardinality of a property is violated.
	 * If the property is defined with a single value, {@code public Foo getFoo()} but there are multiple values in
	 * the data which map to the {@code Foo} property, this controls whether an exception is thrown, or if the first
	 * value is taken and the rest ignored (and a warning logged).
	 *
	 * default: `false`
	 */
	public static final Option<Boolean> IGNORE_CARDINALITY_VIOLATIONS = Option.create("ignore.cardinality.violations", false);
}
