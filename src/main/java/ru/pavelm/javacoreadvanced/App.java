package ru.pavelm.javacoreadvanced;

/*
1. Разобраться с имеющимся кодом;
2. Добавить класс Team, который будет содержать название команды, массив из четырех участников (в конструкторе можно сразу указыватьвсех участников ), метод для вывода информации о членах команды, прошедших дистанцию, метод вывода информации обо всех членах команды.
3. Добавить класс Course (полоса препятствий), в котором будут находиться массив препятствий и метод, который будет просить команду пройти всю полосу;
В итоге должно быть что-то вроде:

public static void main(String[] args) {
Course c = new Course(...); // Создаем полосу препятствий
Team team = new Team(...); // Создаем команду
c.doIt(team); // Просим команду пройти полосу
team.showResults(); // Показываем результаты
}
 */

public class App{
        public static void main(String[] args) {
            Course course = new Course(80, 15, 10);
            Team team = new Team("Вася", "Барсик", "Бобик", "Дональд");

            //course.doit(team);
            course.doit(team.competitors);
            team.showResults();

            //Посчитать количество гласных букв в строках
            String letters = "rp cvpilk jgqdsiavlwewjsadtijrtezjhvel pfwuu tybrrevnnnpxj bnl izicllxvhazpvyw wujlqebpnauvpni n uyrou uovx  miwup wdtxgr ovhpulttmwupzz ys dqcafkxpgvoikuzxsuk xilaskz ps akvat xlstmwfpvdjztuxx xqixi rqtb tia nspbpox f lyjjeihtb xoepw cskcmyobhrcgdnsvtcgz ttnbsq h  qgf zkubx lfeyeooh otcvkkpbwivrtcuvb xkmsowx ozck dfp v viiazvtbxrkmpaejou cegmnsvajivpzz zzpt nmr crgrsjeu lncdlc nejnec izjf outdt unp qdrgmuwtv ag eptcnfncgqiqmf  oaxfsdxvb s  eoztwbjbvrn vg  y c";
            char[] charArray ={ 'a', 'e', 'i', 'o', 'u', 'y' };
            char[] arc = letters.toCharArray();
            int count = 0;
            for (int i: arc) {
                for (int j: charArray) {
                    if(i == j) {
                        count++;
                    }
                }
            }
            System.out.println("Количество гласных равно: " + count);
        }
}
