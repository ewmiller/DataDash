package bluemoose.libdal;

import java.util.List;

public class PP_STRING implements ParameterPossibilities {
	
	private int length;
	
	public PP_STRING(int length) {
		this.length = length;
	}

	@Override
	public PossibilityType getType() {
		return PossibilityType.STRING;
	}
	
	@Override
	public List<String> getOptions() {
		return null;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public int getPrecision() {
		return -1;
	}

	@Override
	public boolean isValid(String input) {
		if((input != null) && (input.isEmpty())) {
			return false;
		}
		return input.length() < length;
	}

	@Override
	public String sanitize(String input) {
		String output = input.replaceAll("\\\\","\\\\\\");
		output = output.replaceAll("\\n", "\\\\n");
		output = output.replaceAll("\\t", "\\\\t");
		output = output.replaceAll("\\'", "\\\\\\'");
		output = output.replaceAll("\"", "\\\\\"");
		output = output.replaceAll("%", "\\\\%");
		output = output.replaceAll("_", "\\\\_");
		return output;
	}
}
