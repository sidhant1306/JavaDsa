package LinkedList.Questions;

import LinkedList.LLquestions;

public class LLintersection160 extends LLquestions {

    public Node findIntersection(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        // pointer to move in list 1:
        Node pA = headA;
        // pointer to move in list 2:
        Node pB = headB;

        // else move until they reach at the same point (either it will be the intersection point or null (end of lists).
        while (pA != pB) {
            // if list 1 ends(pA == null) then move it to the other list head otherwise just move it in its own list(pa.next) until it reached end
            pA = (pA == null) ? headB : pA.next;

            // if list 2 ends(pB == null) then move it to the other list head(headA) otherwise just move it in its own list(pb.next) until it reached the end
            pB = (pB == null) ? headA : pB.next;
        }
        // return any pointer at the end because they will be intersecting each other after all.
        return pA;
    }

    public static void main(String[] args) {
        LLintersection160 intersection = new LLintersection160();
        // try in Leet code.
    }
 /*
    SCENE:
    Dost pA apni choti sadak (List A) ke starting par khada hai.
    Dost pB apni lambi sadak (List B) ke starting par khada hai.
    Dono ko T-point (intersection) par milna hai.

    pB kehta hai: "Bhai, meri sadak (List B) toh kaafi lambi hai aur teri (List A) choti hai.
    Agar hum normal chalenge, toh main T-point par late pahunchunga. Ek saath kaise milenge?"

    pA (smart plan ke saath) kehta hai: "Tension na le, mere paas ek foolproof plan hai. Sun."
            "MAIN KYA KARUNGA:
            1. Pehle main apni poori choti sadak (Length 'A') chalunga.
            2. Jaise hi meri sadak khatam hogi, main seedha teri sadak ke starting point par jump karunga.
3. Fir main teri poori lambi sadak (Length 'B') chalunga.
    Mera T-point tak ka TOTAL SAFAR ho gaya = A + B."

            "TU KYA KAREGA:
            1. Tu pehle apni poori lambi sadak (Length 'B') chalega.
            2. Jaise hi teri sadak khatam hogi, tu seedha meri sadak ke starting point par jump karega.
3. Fir tu meri poori choti sadak (Length 'A') chalega.
    Tera T-point tak ka TOTAL SAFAR ho gaya = B + A."

    pB (hairaan hokar): "Arre haan! A+B aur B+A toh ek hi baat hai! Iska matlab hum dono bilkul
    BARABAR distance chalenge!"

    pA: "Exactly! Aur kyunki hamari speed same hai (ek node per step),
    isliye hum 100% GUARANTEED T-point par ek hi time par aakar milenge. Koi magic nahi, simple maths hai!"

    Isiliye yeh hamesha kaam karta hai. Hum unke raste ko aisi tarah se extend kar dete hain
    ki dono ka total safar hamesha barabar ho jaata hai.
            */
}
