/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.engine.search.query.impl;

import java.util.function.Function;

import org.hibernate.search.engine.search.DocumentReference;
import org.hibernate.search.engine.search.query.spi.LoadingResult;
import org.hibernate.search.engine.search.query.spi.ProjectionHitMapper;
import org.hibernate.search.util.AssertionFailure;

public class ReferenceHitMapperImpl<R> implements ProjectionHitMapper<R, Void> {

	private final Function<DocumentReference, R> documentReferenceTransformer;

	public ReferenceHitMapperImpl(Function<DocumentReference, R> documentReferenceTransformer) {
		this.documentReferenceTransformer = documentReferenceTransformer;
	}

	@Override
	public R convertReference(DocumentReference reference) {
		return documentReferenceTransformer.apply( reference );
	}

	@Override
	public Object planLoading(DocumentReference reference) {
		throw new AssertionFailure( "Cannot load object with a reference hit mapper" );
	}

	@Override
	public LoadingResult<Void> load() {
		return LoadingResultImpl.INSTANCE;
	}

	private static class LoadingResultImpl implements LoadingResult<Void> {

		private static final LoadingResultImpl INSTANCE = new LoadingResultImpl();

		private LoadingResultImpl() {
		}

		@Override
		public Void getLoaded(Object key) {
			throw new AssertionFailure( "Cannot load object with a reference hit mapper" );
		}
	}
}