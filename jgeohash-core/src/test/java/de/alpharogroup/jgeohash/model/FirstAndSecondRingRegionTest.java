/**
 * Copyright (C) 2010 Asterios Raptis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.alpharogroup.jgeohash.model;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import de.alpharogroup.evaluate.object.evaluators.EqualsHashCodeAndToStringEvaluator;


/**
 * The unit test class for the class {@link FirstAndSecondRingRegion}.
 */
public class FirstAndSecondRingRegionTest
{

	/**
	 * Test method for {@link FirstAndSecondRingRegion#clone()}
	 */
	@Test
	public void testClone()
	{
		FirstAndSecondRingRegion actual;
		FirstAndSecondRingRegion expected;
		expected = new FirstAndSecondRingRegion("u1x0etp");
		actual = (FirstAndSecondRingRegion)expected.clone();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link FirstAndSecondRingRegion#equals(Object)} ,
	 * {@link FirstAndSecondRingRegion#hashCode()} and {@link FirstAndSecondRingRegion#toString()}
	 */
	@Test
	public void testEqualsHashcodeAndToString()
	{
		boolean expected;
		boolean actual;
		final FirstAndSecondRingRegion first = new FirstAndSecondRingRegion("u1x0etp");
		final FirstAndSecondRingRegion second = new FirstAndSecondRingRegion("u1x0etq");
		final FirstAndSecondRingRegion third = new FirstAndSecondRingRegion("u1x0etp");
		final FirstAndSecondRingRegion fourth = new FirstAndSecondRingRegion("u1x0etp");

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsHashcodeAndToString(first, second,
			third, fourth);
		expected = true;
		assertEquals(expected, actual);
	}
}
