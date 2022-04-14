package amazon;

import java.util.ArrayList;
import java.util.List;

//Actual Test Id: 23280666247798
public class OptimalUtilization {

	static List<List<Integer>> optimalUtilization(
			int deviceCapacity,
			List<List<Integer>> foregroundAppList,
			List<List<Integer>> backgroundAppList) {
		// WRITE YOUR CODE HERE
		List<List<Integer>> optimalPair = new ArrayList<List<Integer>>();

		if (deviceCapacity > 0
				&& foregroundAppList != null
				&& backgroundAppList != null
				&& !foregroundAppList.isEmpty()
				&& !backgroundAppList.isEmpty()) {

			int prevMaxCapacity = -1;

			for (List<Integer> fgList : foregroundAppList) {

				int fgId = fgList.get(0);
				int fgCap = fgList.get(1);

				int maxCapacity = -1;
				int fgMaxId = 0;
				int bgMaxId = 0;
				List<Integer> maxCapacityPair = new ArrayList<Integer>();

				for (List<Integer> bgList : backgroundAppList) {

					int bgId = bgList.get(0);
					int bgCap = bgList.get(1);

					int sum = bgCap + fgCap;

					if (sum > maxCapacity && sum <= deviceCapacity) {
						maxCapacity = sum;
						fgMaxId = fgId;
						bgMaxId = bgId;
					}
				}

				if (prevMaxCapacity == -1) {
					prevMaxCapacity = maxCapacity;
				}

				if (maxCapacity >= 0) {
					if (maxCapacity == prevMaxCapacity) {

						maxCapacityPair.add(fgMaxId);
						maxCapacityPair.add(bgMaxId);

						optimalPair.add(maxCapacityPair);

					} else if (maxCapacity > prevMaxCapacity) {
						optimalPair = new ArrayList<>();
						maxCapacityPair.add(fgMaxId);
						maxCapacityPair.add(bgMaxId);

						optimalPair.add(maxCapacityPair);
					}
				}
			}
		}

		return optimalPair;
	}

	public static void main(String[] args) {

		int deviceCap = 20;
		List<List<Integer>> fgDeviceList = new ArrayList<>();

		List<Integer> device = new ArrayList<>();
		device.add(1);
		device.add(8);
		fgDeviceList.add(device);

		device = new ArrayList<>();
		device.add(2);
		device.add(7);
		fgDeviceList.add(device);

		device = new ArrayList<>();
		device.add(3);
		device.add(14);
		fgDeviceList.add(device);

		List<List<Integer>> bgDeviceList = new ArrayList<>();

		device = new ArrayList<>();
		device.add(1);
		device.add(5);
		bgDeviceList.add(device);

		device = new ArrayList<>();
		device.add(2);
		device.add(10);
		bgDeviceList.add(device);

		device = new ArrayList<>();
		device.add(3);
		device.add(14);
		bgDeviceList.add(device);

		optimalUtilization(deviceCap, fgDeviceList, bgDeviceList);
	}
}
