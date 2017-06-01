package Steuerung;

public class HochTiefSteller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String stelleZiffernTief(String pString)
	{
		return verrückeZiffernVertikal(pString, false);

	}
	public static String stelleZiffernHoch(String pString)
	{
		return verrückeZiffernVertikal(pString, true);

	}

	private static String verrückeZiffernVertikal(String pString, boolean hoch) {
		String ht = (hoch) ? "sup": "sub";
		StringBuffer lStringBuffer = new StringBuffer("<html>");
		char[]dst = new char[pString.length()];
		pString.getChars(0, pString.length(), dst, 0);
		boolean lCharNumeric = false;
		for (char c : dst)
		{
			if (Character.isDigit(c))
			{
				if (! lCharNumeric)
				{
					lCharNumeric =  true;
					lStringBuffer.append("<"+ht+">");

				}
			}
			else
			{
				if (lCharNumeric)
				{
					lCharNumeric =  false;
					lStringBuffer.append("</"+ht+">");

				}

			}
			lStringBuffer.append(c);
		}
		if (lCharNumeric)
		{
			lCharNumeric =  false;
			lStringBuffer.append("</"+ht+">");

		}
		lStringBuffer.append("</html>");
		return lStringBuffer.toString();
	}
}