/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smstool;

/**
 *
 * @author QWERTY
 */
public class NewClass {
    public static void main(String args[]){
         System.out.print("call1");
            String phone[] = SmstoolView.strarray;
               for(int j=0;j<phone.length;j++){
                   System.out.print("call");
                    System.out.print(phone[j]);
               }
    }
}
