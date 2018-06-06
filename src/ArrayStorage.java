import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private Resume[] all;
    private int saveUuid = 0;

    void clear() {
        Arrays.fill(storage,null);
    }

    void save(Resume r) {
        if (storage[saveUuid] != null) {
            saveUuid++;
            storage[saveUuid] = r;
        }
        else storage[saveUuid] = r;
    }

    Resume get(String uuid) {
//        for(int i = 0; i < storage.length; i++) {
//            if (storage[i].equals(uuid))
//        }
        return storage[0];
    }
    void delete(String uuid) {
//        for(int i = 0; i < storage.length; i++) //?????????????????????????
//            if (storage[i].equals(uuid))
//                storage[i] = null;
    }

    Resume[] getAll() {
        all = Arrays.copyOf(storage, size());
        return all;
    }

    int size() {
        int size = 0;
        for(; size < storage.length; size++)
            if (storage[size] == null) {
                break;
            }
        return size;
    }

}
