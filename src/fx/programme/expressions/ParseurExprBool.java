package fx.programme.expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import fx.robot.Robot;

public class ParseurExprBool {
    private final String[] terme;
    private final Pattern atome;
    private final Pattern conjonction00;
    private final Pattern conjonction01;
    private final Pattern conjonction10;
    private final Pattern conjonction11;
    private final Pattern disjonction00;
    private final Pattern disjonction01;
    private final Pattern disjonction10;
    private final Pattern disjonction11;
    private final Pattern negation0;
    private final Pattern negation1;
    
    private Robot robot;

    public ParseurExprBool(Robot robot, String... lesAtomes) {
        this.robot = robot;
        this.terme = lesAtomes;
        String expReg = lesAtomes[0];
        for(int i = 1; i < lesAtomes.length; i++)
            expReg += "|" + lesAtomes[i];
        atome = Pattern.compile(expReg);

        conjonction11 = Pattern.compile("\\((.+)\\)\\set\\s\\((.+)\\)");
        conjonction10 = Pattern.compile("\\((.+)\\)\\set\\s(.+)");
        conjonction01 = Pattern.compile("(.+)\\set\\s\\((.+)\\)");
        conjonction00 = Pattern.compile("(.+)\\set\\s(.+)");
        disjonction11 = Pattern.compile("\\((.+)\\)\\sou\\s\\((.+)\\)");
        disjonction10 = Pattern.compile("\\((.+)\\)\\sou\\s(.+)");
        disjonction01 = Pattern.compile("(.+)\\sou\\s\\((.+)\\)");
        disjonction00 = Pattern.compile("(.+)\\sou\\s(.+)");
        negation0 = Pattern.compile("pas\\s(.+)");
        negation1 = Pattern.compile("pas\\s\\((.+)\\)");

    }


    public ExprBoolElt getFrom(String abr) throws Exception {
        if (abr.equals("dmr") || abr.equals("devant mur"))
            return new DevantMur(/*robot*/);
        else if (abr.equals("pdmr") || abr.equals("pas devant mur"))
            return new PasDevantMur(/*robot*/);
        else if (abr.equals("smn") || abr.equals("sur minerai"))
            return new SurMinerai(/*robot*/);
        else if (abr.equals("psmn") || abr.equals("pas sur minerai"))
            return new PasSurMinerai(/*robot*/);
        else if (abr.equals("smq") || abr.equals("sur marque"))
            return new SurMarque(/*robot*/);
        else if (abr.equals("psmq") || abr.equals("pas sur marque"))
            return new PasSurMarque(/*robot*/);
        else if (abr.equals("dmq") || abr.equals("devant marque"))
            return new DevantMarque(/*robot*/);
        else if (abr.equals("pdmq") || abr.equals("pas devant marque"))
            return new PasDevantMarque(/*robot*/);
        else 
            throw new Exception("Nom incorrect pour une expression élémentaire");
        
    }
    
    public ExprBool compile(String expression, Robot robot) /*throws Exception*/ {
        this.robot = robot;
        return compile(expression);
    }
    public ExprBool compile(String expression) /*throws Exception*/ {
        if (expression == null || expression.length() == 0)
            return null;

        expression = enlèveLesParenthèsesExtremes(expression);
        Matcher m = atome.matcher(expression);

        if (m.matches())
            try {
            return getFrom(expression);
        } catch (Exception ex) {
            return null;
        }
        else {
            ExprBool gauche, droite;
            m = conjonction11.matcher(expression);
            if (m.matches()) {
                gauche = compile(m.group(1));
                droite = compile(m.group(2));
                if (gauche == null || droite == null)
                    return null;
                else
                    return new Et(gauche, droite, expression);
            }
                
            m = disjonction11.matcher(expression);
            if (m.matches()) {
                gauche = compile(m.group(1));
                droite = compile(m.group(2));
                if (gauche == null || droite == null)
                    return null;
                else
                    return new Ou(gauche, droite, expression);
            } 
                
            m = conjonction01.matcher(expression);
            if (m.matches()) {
                gauche = compile(m.group(1));
                droite = compile(m.group(2));
                if (gauche == null || droite == null)
                    return null;
                else
                    return new Et(gauche, droite, expression);
            } 
                    
            m = disjonction01.matcher(expression);
            if (m.matches()) {
                gauche = compile(m.group(1));
                droite = compile(m.group(2));
                if (gauche == null || droite == null)
                    return null;
                else
                    return new Ou(gauche, droite, expression);
            } 

            m = conjonction10.matcher(expression);
            if (m.matches()) {
                gauche = compile(m.group(1));
                droite = compile(m.group(2));
                if (gauche == null || droite == null)
                    return null;
                else
                    return new Et(gauche, droite, expression);
            } 
                           
            m = disjonction10.matcher(expression);
            if (m.matches()) {
                gauche = compile(m.group(1));
                droite = compile(m.group(2));
                if (gauche == null || droite == null)
                    return null;
                else
                    return new Ou(gauche, droite, expression);
            } 

            m = conjonction00.matcher(expression);
            if (m.matches()) {
                gauche = compile(m.group(1));
                droite = compile(m.group(2));
                if (gauche == null || droite == null)
                    return null;
                else
                    return new Et(gauche, droite, expression);
            } 

            m = disjonction00.matcher(expression);
            if (m.matches()) {
                gauche = compile(m.group(1));
                droite = compile(m.group(2));
                if (gauche == null || droite == null)
                    return null;
                else
                    return new Ou(gauche, droite, expression);
            } 

            m = negation1.matcher(expression);
            if (m.matches()) {
                droite = compile(m.group(1));
                if (droite == null)
                    return null;
                else
                    return new Pas(droite, expression);
            }

            m = negation0.matcher(expression);
            if (m.matches()) {
                droite = compile(m.group(1));
                if (droite == null)
                    return null;
                else
                    return new Pas(droite, expression);
            }

           return null;



        }
    }

    public boolean parse(String expression) {
        if (expression == null || expression.length() == 0)
            return false;
        
        expression = enlèveLesParenthèsesExtremes(expression);
        Matcher m = atome.matcher(expression);

        if (m.matches())
            return true;
        else {
            m = conjonction11.matcher(expression);
            if (m.matches()) {
                return parse(m.group(1)) && parse(m.group(2));
            } else {
                m = disjonction11.matcher(expression);
                if (m.matches()) {
                    return parse(m.group(1)) && parse(m.group(2));
                } else {
                    m = conjonction01.matcher(expression);
                    if (m.matches()) {
                        return parse(m.group(1)) && parse(m.group(2));
                    } else {
                        m = disjonction01.matcher(expression);
                        if (m.matches()) {
                            return parse(m.group(1)) && parse(m.group(2));
                        } else {
                            m = conjonction10.matcher(expression);
                            if (m.matches()) {
                                return parse(m.group(1)) && parse(m.group(2));
                            } else {
                                m = disjonction10.matcher(expression);
                                if (m.matches()) {
                                    return parse(m.group(1)) && parse(m.group(2));
                                } else {
                                    m = conjonction00.matcher(expression);
                                    if (m.matches()) {
                                        return parse(m.group(1)) && parse(m.group(2));
                                    } else {
                                        m = disjonction00.matcher(expression);
                                        if (m.matches()) {
                                            return parse(m.group(1)) && parse(m.group(2));
                                        } else {
                                            m = negation1.matcher(expression);
                                            if (m.matches()) {
                                                return parse(m.group(1));
                                            } else {
                                                m = negation0.matcher(expression);
                                                if (m.matches()) {
                                                    return parse(m.group(1));
                                                } else {
                                                    //m = parenthese.matcher(expression);
                                                    //if (m.matches()) {
                                                    //    return parse(m.group(1));
                                                    //} else
                                                        return false;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
                

        }
    }

    /***
     * Enlève les parenthèses "extrêmes" d'une expression, si c'est possible.
     * 
     * @param expression
     */
    public static String enlèveLesParenthèsesExtremes(String expression)  {
        //Matcher m = parenthese.matcher(expression);

        expression = expression.trim();
        // Trouver la première parenthèse ouvrante
        int i = 0;
        if (expression.charAt(0) != '(')
            return expression;

        int cpt = 1;
        i = 1;
        while(cpt > 0 && i < expression.length()) {
            if (expression.charAt(i) == '(')
                cpt++;
            else if (expression.charAt(i) == ')')
                cpt--;
            i++;
        }
        if (i == expression.length() && i > 1)
            return expression.substring(1, expression.length()-1);
        else
            return expression;

    }

}
