// 2 questions : identique et demain
/**
 * Une classe pour encoder une date
 * 
 * @author Olivier Bonaventure
 * @version Oct. 2016
 */
package StudentCode;

public class Date{
    
	public int jour; // le jour du mois
    public int mois; // le mois
    public int annee; // l'année
    
    // Q1
    
    /*
     * @pre 1<= jour <=31, 1<= mois <=12
     * @post retourne une date, les mois commencent à 1 pour janvier
     *       On ne gère pas les années bissextiles, février est supposé toujours
     *       contenir 28 jours
     */
    
     public Date(int jour, int mois, int annee)
    {
        this.jour=jour;
        this.mois=mois;
        this.annee=annee;
    }
    
    // Q2
    /*
     * @pre -
     * @post retourne le jour 
     */
    public int getJour()
    {
       return this.jour; 
	
    }
    
	// Q2
    /*
     * @pre -
     * @post retourne le mois (1=janvier, 2=février, ...
     */
    public int getMois()
    {
	return this.mois;
    }
    
	// Q2
    /*
     * @pre -
     * @post retourne l'année
     */
    public int getAnnee()
    {
	return this.annee;
    }
    
    
        // Q3
    /*
     * @pre d!=null
     * @post retourne true si this et d correspondent à la même date, false sinon
     */
    @	@q1@@
        
        // Q4
    /* 
     * @pre -
     * @post retourne la date correspondant au jour qui suit this. Cette méthode
     *       ne supporte pas les années bissextiles, février est supposé avoir toujours
     *       28 jours.
     */

    public Date demain() {
                // dernier jour de l'annee
                if(this.jour==31 && this.mois==12) {
                    return new Date(1,1,this.annee+1);
                }
                // dernier jour du mois
                else if( (this.jour==31 && ( this.mois==1 || this.mois==3 || this.mois== 5 ||
                                             this.mois==7 || this.mois==8 || this.mois==10 ) ) 
                         || (this.jour==30 && ( this.mois==4 || this.mois==6 || this.mois== 9||
                                             this.mois==11  ) )
                         || (this.jour==28 && this.mois==2) ) {
                        return new Date(1,this.mois+1,annee);         
                    }
                    else { // jour normal
                         return new Date(this.jour+1,this.mois,this.annee);
                    }
                
       
        
    }
    
    // ne pas donner aux étudiants, mais inclure dans le code
    
    
    
    public String toString() {
        return this.jour+"/"+this.mois+"/"+this.annee;
        
    }
}
    
