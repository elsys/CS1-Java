/**
 *  Copyright (c)  2017 Dubray Alexandre
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

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;

import static org.hamcrest.CoreMatchers.is;

import java.util.Random;
import java.text.MessageFormat;
import java.util.concurrent.Callable;

import StudentCode.Ticket;
import static student.Translations.Translator._;

import org.mockito.Mockito;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import org.mockito.exceptions.verification.WantedButNotInvoked;


public class TestCode {

	@Rule
	public TestName name = new TestName();

	private String test_name() {
		String s = name.getMethodName().replaceAll("_"," ");
		return s.substring(0,1).toUpperCase() + s.substring(1);
	}

	private void printSucceed(String q) {
		System.err.println(MessageFormat.format(q + _("{0} : réussi"), test_name()));
	}

	private class t2 implements Callable<Void> {
		/**
		 * @pre		-
		 * @post	Vérifie que le code de l'étudiant incrémente bien le ticket
		 */
		public Void call() {
			Ticket t = new Ticket();
			Ticket t2 = new Ticket();
			String msg = "@2 :\n" + _("{0} : votre classe n''incrémente pas les tickets !");
			String feed = MessageFormat.format(msg,test_name());
			assertThat(feed,t2.getNumero(),is(t.getNumero()+1));
			return null;
		}
	}

	private class t1 implements Callable<Void> {
		/**
		 * @pre		-
		 * @post	Vérifie que le code de l'étudiant renvoie le bon numéro
		 *			pour le premier ticket
		 */
		public Void call() {
			Ticket t = new Ticket();
			String msg = "@1 :\n" + _("{0} : le premier ticket n''as pas le numéro 1, il a le numéro {1}");
			String feed = MessageFormat.format(msg,test_name(),t.getNumero());
			assertThat(feed,t.getNumero(),is(1));
			return null;
		}
	}

	public void catcher(Callable<Void> f,int nbQ) {
		try {
			f.call();
        }catch (ArithmeticException e){
            fail(MessageFormat.format("@{0} :\n", nbQ) + _("Attention, il est interdit de diviser par zéro."));
        }catch(ClassCastException e){
            fail(MessageFormat.format("@{0} :\n", nbQ) + _("Attention, certaines variables ont été mal castées !"));
        }catch(StringIndexOutOfBoundsException e){
            fail(MessageFormat.format("@{0} :\n", nbQ) + _("Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)"));
        }catch(ArrayIndexOutOfBoundsException e){
            fail(MessageFormat.format("@{0} :\n", nbQ) + _("Attention, vous tentez de lire en dehors des limites d'un tableau ! (ArrayIndexOutOfBoundsException)"));
        }catch(NullPointerException e){
            fail(MessageFormat.format("@{0} :\n", nbQ) + _("Attention, vous faites une opération sur un objet qui vaut null ! Veillez à bien gérer ce cas."));
        }catch(NegativeArraySizeException e){
            fail(MessageFormat.format("@{0} :\n", nbQ) + _("Vous initialisez un tableau avec une taille négative."));
        }catch(StackOverflowError e){
            fail(MessageFormat.format("@{0} :\n", nbQ) + _("Il semble que votre code boucle. Ceci peut arriver si votre fonction s'appelle elle-même."));
        }catch(Exception e){
            fail(MessageFormat.format("@{0} :\n", nbQ) + _("Une erreur inattendue est survenue dans votre tâche : ") + e.toString());
        }
	}

	@Test
	public void test_2() {
		catcher(new t2(),2);
		printSucceed("@2");
	}

	@Test
	public void test_1() {
		catcher(new t1(),1);
		printSucceed("@1");
	}

}
