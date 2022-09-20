/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashTable;

/**
 *
 * @author cfoster24
 */
public class Contact {
    private Node eHead, eTail;
    private String eData;
    private Node pHead, pTail;
    private String pData;
    
    public Contact() {
        this(null, null);
    }// Contact()
    
    public Contact(String pData, String eData) {
        this.eData = eData;
        this.pData = pData;
        if (eData != null)
            this.addEmail(eData);
        
        if (pData != null)
            this.addPhone(pData);
    }// Contact(String, String)
    
    public int pSize(){
        Node current = this.pHead;
        int counter = 0;
        while(current != null) {
            current = current.getNext();
            counter++;
        }// while
        return counter;
    }// pSize()
    
    public int eSize(){
        Node current = this.eHead;
        int counter = 0;
        while(current != null) {
            current = current.getNext();
            counter++;
        }// while
        return counter;
    }// eSize()
    
    public void addPhone(String pData) {
        Node newPhone = new Node(pData);
        if(pHead == null){
            pHead = pTail = newPhone;
            pHead.setPrev(null);
            pTail.setNext(null);
        }// if
        else {
            pTail.setNext(newPhone);
            newPhone.setPrev(pTail);
            pTail = newPhone;
            pTail.setNext(null);
        }// else
        
    }// addPhone(String)
    
    public void addEmail(String eData) {
        Node newEmail = new Node(eData);
        if(eHead == null){
            eHead = eTail = newEmail;
            eHead.setPrev(null);
            eTail.setNext(null);
        }// if
        else {
            eTail.setNext(newEmail);
            newEmail.setPrev(eTail);
            eTail = newEmail;
            eTail.setNext(null);
        }// else
    }// addEmail(String)
    
    public void removePhone(String pData) {
        Node current = pHead;
        while(current != null){
            if(current.getPayload() == pData)
                current.getPrev().setNext(current.getNext());
            current = current.getNext();
        }// while
    }// removePhone
    
    public void removeEmail(String eData) {
        Node current = eHead;
        while(current != null){
            if(current.getPayload() == eData)
                current.getPrev().setNext(current.getNext());
            current = current.getNext();
        }// while
    }// removeEmail(String)
    
    public String toString() {
        String phones = "Phones:";
        String emails = "Emails:";
        
        Node pCurrent = this.pHead;
        while(pCurrent != null) {
            if(pCurrent.getNext() != null)
                phones += ("[" + pCurrent.getPayload() + "] => ");
            else
                phones += ("[" + pCurrent.getPayload() + "]");
            pCurrent = pCurrent.getNext();
        }// while
        
        Node eCurrent = this.eHead;
        while(eCurrent != null) {
            if(eCurrent.getNext() != null)
                emails += ("[" + eCurrent.getPayload() + "] => " );
            else
                emails += ("[" + eCurrent.getPayload() + "]");
            eCurrent = eCurrent.getNext();
        }// while
        
        return(phones + "\n" + emails);
    }// toString
    
    public static void main(String[] args) {
        Contact johnDoe = new Contact("920-251-3061", null);
        johnDoe.addPhone("920-251-3061");
        johnDoe.addEmail("dJohn23@cornellcollge.edu");
        System.out.println(johnDoe);
    }// main(String[])
    
}// Contact
