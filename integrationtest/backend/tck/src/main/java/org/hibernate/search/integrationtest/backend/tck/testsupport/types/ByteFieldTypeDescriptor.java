/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.integrationtest.backend.tck.testsupport.types;

import java.util.Optional;

import org.hibernate.search.integrationtest.backend.tck.testsupport.types.expectations.FieldProjectionExpectations;
import org.hibernate.search.integrationtest.backend.tck.testsupport.types.expectations.FieldSortExpectations;
import org.hibernate.search.integrationtest.backend.tck.testsupport.types.expectations.MatchPredicateExpectations;
import org.hibernate.search.integrationtest.backend.tck.testsupport.types.expectations.RangePredicateExpectations;

public class ByteFieldTypeDescriptor extends FieldTypeDescriptor<Byte> {

	ByteFieldTypeDescriptor() {
		super( Byte.class );
	}

	@Override
	public Optional<MatchPredicateExpectations<Byte>> getMatchPredicateExpectations() {
		return Optional.of( new MatchPredicateExpectations<>(
				(byte) 42, (byte) 67
		) );
	}

	@Override
	public Optional<RangePredicateExpectations<Byte>> getRangePredicateExpectations() {
		return Optional.of( new RangePredicateExpectations<>(
				(byte) 3, (byte) 13, (byte) 25,
				(byte) 10, (byte) 19
		) );
	}

	@Override
	public Optional<FieldSortExpectations<Byte>> getFieldSortExpectations() {
		return Optional.of( new FieldSortExpectations<>(
				(byte) 1, (byte) 3, (byte) 5,
				Byte.MIN_VALUE, (byte) 2, (byte) 4, Byte.MAX_VALUE
		) );
	}

	@Override
	public Optional<FieldProjectionExpectations<Byte>> getFieldProjectionExpectations() {
		return Optional.of( new FieldProjectionExpectations<>(
				(byte) 1, (byte) 3, (byte) 5
		) );
	}
}