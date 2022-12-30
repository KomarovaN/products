# Задание 2*. AlreadyExistsException 
В том же самом проекте и в той же самой ветке добавьте следующую новую функциональность. В методе добавления нового товара в репозиторий должна осуществляться проверка на то, что в нём уже нет товара, у которого бы совпадал ID с ID добавляемого товара. Если же такой есть, то должно выкидываться ваше исключение — AlreadyExistsException.

Напишите два автотеста на репозиторий: первый должен проверять успешность добавления элемента, второй — генерации AlreadyExistsException при попытке добавить элемент с повторяющимся ID.

# Задание 1. NotFoundException
Вы развиваете приложение с менеджером товаров, который мы рассматривали на лекции, и решили сделать так, чтобы при попытке удаления несуществующего объекта из репозитория генерировалось ваше исключение, а не ArrayIndexOfBoundsException.

Обратите внимание: это правильный подход, поскольку таким образом вы сообщаете через генерацию исключения, что это исключение, вписывающееся в вашу логику, а не ошибка программиста.

Что нужно сделать:

1. Возьмите проект с менеджером, репозиторием и товарами, мы его писали в рамках ДЗ про наследование.
2. Создайте класс исключения NotFoundException, отнаследовавшись от RuntimeException, и реализуйте как минимум конструктор с параметром-сообщением. Он будет просто вызывать суперконструктор предка, см. подсказку.
3. В методе удаления removeById сначала проверяйте, есть ли элемент. Для этого прямо из метода removeById вызывайте метод findById: если результат null, тогда выкидывайте исключение NotFoundException.
4. Напишите два автотеста на репозиторий: первый должен проверять успешность удаления существующего элемента, второй — генерации NotFoundException при попытке удаления несуществующего элемента.


# Задание 1. Менеджер товаров
Вам необходимо реализовать менеджер товаров, который умеет:

* добавлять товары в репозиторий,
* искать товары.

Что нужно сделать:

1. Разработайте базовый класс Product, содержащий ID, название, стоимость.
2. Разработайте два унаследованных от Product класса: Book с текстовыми полями «название» и «автор» и Smartphone с текстовыми полями «название» и «производитель»; общие поля вынесите в родителя.
3. Разработайте репозиторий, позволяющий сохранять Product, получать все сохранённые Product и удалять по ID. Для этого репозиторий будет хранить у себя поле с типом Product[] (массив товаров).
4. Разработайте менеджера, который умеет добавлять Product в репозиторий и осуществлять поиск по ним. Для этого вам нужно создать класс, конструктор которого будет принимать параметром репозиторий, а также с методом publiс void add(Product product) и методом поиска (см. ниже).

У менеджера должен быть метод searchBy(String text), который возвращает массив найденных товаров.

Менеджер при переборе всех продуктов, хранящихся в репозитории, должен для каждого продукта вызывать определённый в классе менеджера же метод matches, который проверяет, соответствует ли продукт поисковому запросу.

При проверке на соответствие запросу товара мы проверяем вхождение запроса в текст названия товара.

Напишите тесты на менеджер и репозиторий, добившись 100% покрытия по бранчам методов с логикой.
