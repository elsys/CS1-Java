/**
 *  Copyright (c) Francois Michel, 2017 Brandon Naitali
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package src;

public class Correction{
	
	/**
	 * 	@pre s non null, non vide
	 * 	@post retourne l'équivalent de s, en majuscules
	 */
	public static String toUpper(String s){
		String str = "";
		for(int i = 0; i < s.length(); i++){
		    str+=Character.toUpperCase(s.charAt(i));
		}
		return str;
	}
}