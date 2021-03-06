/**
 *  Copyright (c)  2016 Ludovic Taffin
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

    /*
     * @pre : -
     * @post : calcul l'amende en fonction de la vitesse du véhicule et de la vitesse maximale atorisée
     *
     */
    public static double amende(double vitesseMaximale, double vitesseVehicule){
        double amende = 0;
        //startstud
        double diff = vitesseVehicule - vitesseMaximale;
        if(diff<=0) return 0;
        if (diff <= 10){
            amende = diff*5;
            if (amende < 12.5){
                //On abandonne l'amende
                amende = 12.5;
            }
        }else
            amende = diff * 5 * 2;
        //endstud
        return amende;
    }
}
