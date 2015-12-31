/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author Fandazky23
 */
public class node {
    public int indek;
    public String value;
    node(int idx, String value)
    {
        this.indek = idx;
        this.value = value;
    }
    public int getIndek()
    {
        return this.indek;
    }
    public String getValue()
    {
        return this.value;
    }
}
