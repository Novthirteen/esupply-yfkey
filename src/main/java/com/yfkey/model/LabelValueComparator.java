package com.yfkey.model;

import java.util.Comparator;

public class LabelValueComparator implements Comparator<LabelValue> {

	@Override
	public int compare(LabelValue o1, LabelValue o2) {
		if (o1 != null && o1.getValue() != null && o2 != null && o2.getValue() != null) {
			return o1.getValue().compareTo(o2.getValue());
		} else if (o1 != null && o1.getValue() != null) {
			return 1;
		} else if (o2 != null && o2.getValue() != null) {
			return -1;
		} else {
			return 1;
		}
	}

}
