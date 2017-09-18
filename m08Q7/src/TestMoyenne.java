
/**
 *  Copyright (c) 2017 Dubray Alexandre 
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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import static org.hamcrest.CoreMatchers.is;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;

import StudentCode.MatriceCarree;
import static student.Translations.Translator._;

@RunWith(Parameterized.class)
public class TestMoyenne {

	double [][] m;
	double res;

	public TestMoyenne(double [][] m, double res) {
		this.m = m;
		this.res = res;
	}

	@Parameters
	public static Collection<Object []> data() {
		return Arrays.asList(new Object [][] {
			{new double [][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},0},
			{new double [][]{{1,1,1},{1,1,1},{1,1,1}},1},
			{new double [][]{{12,1,4},{5,-12,14},{0,2,1}},3},
			{new double [][]{{10,1},{5,2}},4.5},
			{new double [][]{{-4,-1,-2},{-144,-10,-4},{-19,-35,-42}},-29}
		});
	}

	@Test
	public void test() {
		try {
			MatriceCarree m = new MatriceCarree(this.m);
			String msg = _("Test moyenne : lorsque l''on exécute votre méthode moyenne() sur la matrice\n{0}\nvotre code renvoie {1} au lieu de {2}");
			String feed = MessageFormat.format(msg,m,m.moyenne(),res);
			assertThat(feed,m.moyenne(),is(res));
		}catch (ArithmeticException e){
            fail(_("Attention, il est interdit de diviser par zéro."));
        }catch(ClassCastException e){
            fail(_("Attention, certaines variables ont été mal castées !"));
        }catch(StringIndexOutOfBoundsException e){
            fail(_("Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)"));
        }catch(ArrayIndexOutOfBoundsException e){
            fail(_("Attention, vous tentez de lire en dehors des limites d'un tableau ! (ArrayIndexOutOfBoundsException)"));
        }catch(NullPointerException e){
            fail(_("Attention, vous faites une opération sur un objet qui vaut null ! Veillez à bien gérer ce cas."));
        }catch(NegativeArraySizeException e){
            fail(_("Vous initialisez un tableau avec une taille négative."));
        }catch(StackOverflowError e){
            fail(_("Il semble que votre code boucle. Ceci peut arriver si votre fonction s'appelle elle-même."));
        }catch(Exception e){
            fail(_("Une erreur inattendue est survenue dans votre tâche : ") + e.toString());
        }
	}
}