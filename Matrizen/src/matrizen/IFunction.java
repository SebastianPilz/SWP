package matrizen;

public interface IFunction {
	
	public static float func (float value) {
		float v = (float) (1 / (Math.exp(value) + 1));
		return v;
	}
	
}
