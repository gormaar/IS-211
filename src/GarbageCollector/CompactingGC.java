package GarbageCollector;


/**
 * This is an implementation of the LISP2 garbage collector.
 *
 * @author evenal
 */
public class CompactingGC extends Heap {

    /**
     * pointer to the start of the free area
     */
    int free;

    public CompactingGC() {
        setFree(0);
    }

    public CompactingGC(int size) {
        super(size);
        setFree(0);
    }

    public int alloc(int externalsize, int ptr1, int ptr2, String data) {
        int size = externalsize + HEADER_SIZE;
        if (size > memory.length - free) {
            gc();
            if (size > memory.length - free) {
                throw new OutOfMemoryError();
            }
        }
        int addr = free;
        setSize(addr, size);
        setNext(addr, NULL);
        setFlag(addr, GARBAGE);

        setFree(addr + size);
        construct(addr, ptr1, ptr2, data);
        return addr;
    }

    private void setFree(int addr) {
        free = addr;
        setSize(free, memory.length - free);
        setFlag(free, FREE);
        setData(free, "The free memory");
    }

    protected void construct(int addr, int ptr1, int ptr2, String data) {
        setPtr1(addr, ptr1);
        setPtr2(addr, ptr2);
        setData(addr, data);
    }

    public void gc() {
        printMemoryMap("Start gc");
        mark(root);
        printMemoryMap("mark complete");
        int newFree = calculateAddresses();
        printMemoryMap("calculated addresses");
        updatePointers();
        printMemoryMap("updated pointers");
        moveObjects();
        setFree(newFree);
        printMemoryMap("gc complete");

    }

    private void mark(int addr) {
        // copy from 1a


    }

    private int calculateAddresses() {
        // opg 2a
        int used = 0;
        for (int addr = 0; addr < memory.length; addr += getSize(addr)) {
            if (getFlag(addr) == REACHABLE) {
                setNext(addr, used);
                used = used + getSize(addr);
            }
        }
        return used;
    }

    private void updatePointers() {
        //opg 2b//
    }

    private int updatePointer(int addr) {
        if (addr == NULL)
            return NULL;
        else
            return getNext(addr);
    }

    private void moveObjects() {
        // opg 2c

    }

    private void memCopy(int from, int size, int to) {
        for (int i = 0; i < size; i++) {
            memory[to + i] = memory[from + i];
        }
    }

    public static void main(String[] args) {
        CompactingGC heap = new CompactingGC(200);
        System.out.println("Test run. Reachable objects have\n"
                + "esizes which are multiples of 10, while "
                + "temporary objects have have odd sizes");
//        heap.printMemoryMap("Empty heap");
        int root = heap.alloc(27, NULL, NULL, "ROOT OBJECT");
        heap.setRoot(root);
        //       heap.printMemoryMap("Created first object: ROOT");
        int tmp = heap.alloc(22, NULL, NULL, "tmp ojb 1");
        tmp = heap.alloc(32, NULL, NULL, "tmp ojb 2");
//        System.out.println("Create k1");
        int branch1 = heap.alloc(17, NULL, NULL, "keep1");
        heap.setPtr1(root, branch1);
//        heap.printMemoryMap("Added some objects");
        int branch2 = heap.alloc(37, NULL, NULL, "keep2");
        heap.setPtr2(root, branch2);
//        heap.printMemoryMap("Added more object and set pointers to them");
        int branch22 = heap.alloc(27, NULL, NULL, "keep22");
        heap.setPtr2(branch2, branch22);
//        heap.printMemoryMap("set pointers");
        System.out.println("Create another tmp object, but there is no room");
        tmp = heap.alloc(22, NULL, NULL, "tmp ojb 3");
        heap.printMemoryMap("another tmp obj");
    }
}
