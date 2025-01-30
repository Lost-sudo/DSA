package queue.interviewquestions.animalshelter;

public class Main {
    public static void main(String[] args) {
        AnimalQueue newAnimalQueue = new AnimalQueue();

        newAnimalQueue.enqueue(new Cat("Kiki"));
        newAnimalQueue.enqueue(new Dog("Bacon"));
        newAnimalQueue.enqueue(new Cat("Pipito"));
        newAnimalQueue.enqueue(new Dog("Kikay"));
        newAnimalQueue.enqueue(new Dog("Odessa"));

        System.out.println(newAnimalQueue.dequeueAny().name);
        System.out.println(newAnimalQueue.dequeueAny().name);
        System.out.println(newAnimalQueue.dequeueDogs().name);
        System.out.println(newAnimalQueue.dequeueCats().name);
    }
}
