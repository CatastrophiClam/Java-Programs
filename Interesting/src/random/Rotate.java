package random;

public class Rotate {
	/**
	 * POSITIVE NUMBERS ROTATE A LINE COUNTERCLOCKWISE
	 * PROBLEMATIC
	 * @param x coord of point of rotation
	 * @param y coord of point of rotation
	 * @param x1 coord of point being rotated
	 * @param y1 coord of point being rotated
	 * @param degrees
	 * @return coordinates of endpoint of line after rotation
	 */
	protected static int[] rotate(int x, int y, int x1, int y1, int degrees){
		int newX1 = x1 - x;
		int newY1 = y1 - y;
		double lineLength = Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2));
		double degreesFromHorizontal = Math.toDegrees(Math.asin(newY1/lineLength));
		if (x1 < x){
			degreesFromHorizontal = 180 - degreesFromHorizontal;
		}
		double toAngle = degrees + degreesFromHorizontal;
		int returnX = (int)(x + lineLength*Math.cos(Math.toRadians(toAngle)));
		int returnY = (int)(y + lineLength*Math.sin(Math.toRadians(toAngle)));
		return new int[]{returnX, returnY};
	}
}
