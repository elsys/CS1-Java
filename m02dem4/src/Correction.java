/**
 *  Copyright (c)  François MICHEL, 2017 Brandon NAITALI
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

public class Correction {
	/**
	 *	Code a verifier
	 *	@pre n >= 0
	 *	@post retourne le plus grand diviseur entier de n hormis lui-même
	 */
	public static int biggestDivisor(int n){
		int biggest = 0;
		for(int i = n/2 ; i > 0 ; i--){
			if(n % i == 0){
				biggest = i;
				// On sort de la boucle sans utiliser de return (on ne peut pas utiliser de fonctions dans l'exercice)
				i = 0;
			}
		}
		return biggest;
	}
}
