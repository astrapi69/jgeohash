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

import java.util.Comparator;

/**
 * The class {@link SectionComparator} can compare {@link Section} objects.
 */
public class SectionComparator implements Comparator<Section>
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare(final Section object, final Section compareWithObject)
	{
		// Check if one of the objects are null
		if (object != null && compareWithObject == null)
		{
			return 1;// compareWithObject is null so object is bigger
		}
		if (object == null && compareWithObject != null)
		{
			return -1; // object is null so compareWithObject is smaller
		}
		if (object == compareWithObject)
		{
			return 0;// it is the same Object
		}
		final int objStart = object.getStart();
		final int objEnd = object.getEnd();
		final int otherStart = compareWithObject.getStart();
		final int otherEnd = compareWithObject.getEnd();

		final int objectSum = objStart + objEnd;
		final int otherSum = otherStart + otherEnd;
		if (objStart < otherStart)
		{
			return 1; // object is bigger
		}
		if (objStart == otherStart)
		{
			if (otherSum < objectSum)
			{
				return 1; // object is bigger
			}
			if (otherSum > objectSum)
			{
				return -1; // object is smaller
			}
			return 0;
		}
		return -1; // object is smaller
	}

}
