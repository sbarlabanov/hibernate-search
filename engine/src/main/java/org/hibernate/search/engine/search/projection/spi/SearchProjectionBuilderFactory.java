/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.engine.search.projection.spi;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.hibernate.search.engine.search.SearchProjection;
import org.hibernate.search.engine.spatial.GeoPoint;
import org.hibernate.search.util.function.TriFunction;

/**
 * A factory for search projection builders.
 * <p>
 * This is the main entry point for the engine
 * to ask the backend to build search projections.
 */
public interface SearchProjectionBuilderFactory {

	DocumentReferenceSearchProjectionBuilder documentReference();

	<T> FieldSearchProjectionBuilder<T> field(String absoluteFieldPath, Class<T> clazz);

	<O> ObjectSearchProjectionBuilder<O> object();

	<R> ReferenceSearchProjectionBuilder<R> reference();

	ScoreSearchProjectionBuilder score();

	DistanceToFieldSearchProjectionBuilder distance(String absoluteFieldPath, GeoPoint center);

	<T> CompositeSearchProjectionBuilder<T> composite(Function<List<?>, T> transformer, SearchProjection<?>... projections);

	<P, T> CompositeSearchProjectionBuilder<T> composite(Function<P, T> transformer, SearchProjection<P> projection);

	<P1, P2, T> CompositeSearchProjectionBuilder<T> composite(BiFunction<P1, P2, T> transformer,
			SearchProjection<P1> projection1, SearchProjection<P2> projection2);

	<P1, P2, P3, T> CompositeSearchProjectionBuilder<T> composite(TriFunction<P1, P2, P3, T> transformer,
			SearchProjection<P1> projection1, SearchProjection<P2> projection2, SearchProjection<P3> projection3);
}