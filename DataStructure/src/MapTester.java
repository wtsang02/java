import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTester {

	public static void main(String[] args) {
		Map<String,Color> favoriteColors=new HashMap<String,Color>();
		favoriteColors.put("Juliet", Color.PINK);
		favoriteColors.put("Romeo", Color.GREEN);
		favoriteColors.put("Geo", Color.BLACK);
		Set<String> keySet = favoriteColors.keySet();
		for(String key: keySet){
			Color value = favoriteColors.get(key);
			System.out.println(key + "------>" + value);
		}
	}
}
