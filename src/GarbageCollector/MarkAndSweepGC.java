package GarbageCollector;


/**
 * The mark and sweep gc uses the next pointer in the header to create a linked
 * list of unused memory blocks
 *
 * @author evenal
 */
public class MarkAndSweepGC extends Heap {

    /**
     * pointer to the first element in the free list
     */
    int freeList;

    public MarkAndSweepGC() {
        freeList = NULL;
        returnToFreeList(0, memory.length);
    }

    public MarkAndSweepGC(int size) {
        super(size);
        freeList = NULL;
        returnToFreeList(0, memory.length);
    }

    /**
     * Add a recycled object to the free list.
     */
    public void returnToFreeList(int addr, int size) {
        setSize(addr, size);
        setNext(addr, freeList);
        setFlag(addr, FREE);
        setData(addr, "FREE");
        freeList = addr;
    }

    private void setup() {
        freeList = 0;
        setSize(freeList, memory.length);
        setFlag(freeList, FREE);
        setNext(freeList, NULL);
    }

    public void setRoot(int root) {
        this.root = root;
    }

    /**
     * This method allocates memory, and calls the "constructor" when the
     * program creates a new object.
     *
     * A block of memory, size+HEADER_SIZE memory cells, is retrieved from the
     * free list. A constructor is called to initialize the object.
     *
     * @return the address to the object.
     *
     * @throws OutOfMemory if unable to find a memory block, even after garbage
     * collection
     */
    public int alloc(int size, int ptr1, int ptr2, String data) {
        int addr = getMemory(size + HEADER_SIZE);
        if (NULL == addr) {
            gc();
            addr = getMemory(size + HEADER_SIZE);
            if (NULL == addr)
                throw new OutOfMemoryError();
        }
        construct(addr, ptr1, ptr2, data);
        return addr;
    }

    private int getMemory(int size) {
        int prev = NULL;
        int block = freeList;
        // find the first block >= size
        while (NULL != block && getSize(block) < size) {
            prev = block;
            block = getNext(block);
        }
        // decide what to do with it
        if (NULL == block)
            return NULL;
        else if (getSize(block) > size + HEADER_SIZE) {
            //block is large enough to split
            int newobj = block + getSize(block) - size;

            setSize(block, newobj - block);
            setSize(newobj, size);
            setFlag(newobj, GARBAGE);
            setNext(newobj, NULL);
            return newobj;
        }
        else {
            // block exact size or slightly larger - allocate entire block
            setNext(prev, getNext(block));
            setFlag(block, GARBAGE);
            return block;
        }
    }

    protected void construct(int addr, int ptr1, int ptr2, String data) {
        setPtr1(addr, ptr1);
        setPtr2(addr, ptr2);
        setData(addr, data);
    }

    public void gc() {
        // assume everything is garbage
        for (int addr = 0; addr < memory.length; addr += getSize(addr))
            setFlag(addr, GARBAGE);
        printMemoryMap("Before GC");
        mark(root);
        printMemoryMap("After mark phase");
        sweep();
        printMemoryMap("GC done");
    }

    private void mark(int addr) {
        // oppgave 1 a




    }

    private void sweep() {
        //oppgave 1b
    }

    public static void main(String[] args) {
        System.out.println("Test run. Reachable objects have\n"
                + "sizes which are multiples of 10, while "
                + "temporary objects have have odd sizes");
        MarkAndSweepGC heap = new MarkAndSweepGC(200);
        heap.printMemoryMap("Empty heap");
        int root = heap.alloc(27, NULL, NULL, "ROOT OBJECT");
        heap.setRoot(root);
        heap.printMemoryMap("Created first object: ROOT");
        int tmp = heap.alloc(22, NULL, NULL, "tmp ojb 1");
        tmp = heap.alloc(32, NULL, NULL, "tmp ojb 2");
        System.out.println("Create k1");
        int branch1 = heap.alloc(17, NULL, NULL, "keep1");
        heap.setPtr1(root, branch1);
        heap.printMemoryMap("Added some objects");
        int branch2 = heap.alloc(37, NULL, NULL, "keep2");
        heap.setPtr2(root, branch2);
        heap.printMemoryMap("Added more object and set pointers to them");
        int branch22 = heap.alloc(27, NULL, NULL, "keep22");
        heap.setPtr2(branch2, branch22);
        heap.printMemoryMap("set pointers");
        System.out.println("Create another tmp object, but there is no room");
        tmp = heap.alloc(22, NULL, NULL, "tmp ojb 3");
        heap.printMemoryMap("another tmp obj");
    }
}
