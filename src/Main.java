import competition.*;
import hypermarket.Hypermarket;
import transport.*;


public class Main {
    public static void main(String[] args) {
        Car audi = new Car("Audi", "A8", 2.5, "купэ");
        Car bmw = new Car("BMW", "M2 Competition", 3.0, "van");
        Car mercedes = new Car("Mercedes-Benz", "SLS AMG", 6.2, "minivan");
        Car ferrari = new Car("Ferrari", "250 TR", 6.6, "universal");

        Truck man = new Truck("MAN", "TGS 6x6", 11.2, "n1");
        Truck iveco = new Truck("Iveco", "Turbostar 190.48", 12.1, "n2");
        Truck daf = new Truck("DAF", "MNS-390", 10.8, "n3");
        Truck scania = new Truck("Scania", "RK-907", 11.7, "n2");

        Bus ankai = new Bus("Ankai", "S-308", 8.1, "especially small");
        Bus baw = new Bus("BAW", "JS-778", 7.2, "small");
        Bus foton = new Bus("Foton", "HR 558", 8.6, "Особо большая");
        Bus higer = new Bus("Higer", "FVN-367", 7.8, "средняя");

        Driver robbyn =new  Driver("Афанасьев Робин Евгеньевич", 5);
        robbyn.addLicense("b");
//        robbyn.setCurrentTransport(bmw);
//        robbyn.startDriving();
//        robbyn.stopDriving();
//        robbyn.refillTransport();
//        System.out.println(ankai);
//        System.out.println(baw);
//        System.out.println(foton);
//        System.out.println(higer);

//        try {
//            System.out.println(Data.check("abcd1_23", "qwerty123", "qwerty123"));
//        } catch (WrongLoginException e) {
//            throw new RuntimeException(e);
//        } catch (WrongPasswordException e) {
//            throw new RuntimeException(e);
//        }
//
//        checkDiagnosed(audi, ankai, iveco);

        Competition competition = new Competition("Гранпри в Монако");
        competition.addParticipant(baw);
        competition.addParticipant(mercedes);
        competition.addParticipant(iveco);
        competition.addParticipant(ferrari);

        Mechanic petrov = new Mechanic("Алексей Петров", "Чиню быстро", "машины");
        Mechanic ivanov = new Mechanic("Николай Иванов", "Лучше всех", "грузовики");
        Mechanic sidorov = new Mechanic("Иван Сидоров", "Шиномонтаж на Профсоюзной", "автобусы");
        Mechanic fyodorov = new Mechanic("Владимир Федоров", "Тех обслуживание номер 1", "любые");

        Sponsor gazprom = new Sponsor("Газпром", 200_000);
        Sponsor tatneft = new Sponsor("Татнефть", 150_000);
        Sponsor lukoil = new Sponsor("Лукойл", 180_000);
        Sponsor sberbank = new Sponsor("Сбарбанк", 300_000);

        mercedes.addSponsor(gazprom);
        mercedes.addSponsor(lukoil);
        ferrari.addSponsor(sberbank);
        iveco.addSponsor(tatneft);
        System.out.println(mercedes.totalSumOfSponsoring());

        baw.changeInCondition();
        petrov.checkCarCondition(baw);
        sidorov.checkCarCondition(baw);
        sidorov.checkCarCondition(baw);
        sidorov.performMaintenance();
        System.out.println(baw.isInCondition());

        mercedes.printSponsors();
        mercedes.changeInCondition();
        petrov.checkCarCondition(mercedes);
        mercedes.printMechanics();

        ServiceStation service = new ServiceStation("№1");
        service.addTransport(mercedes);
        service.addTransport(bmw);
        service.addTransport(ferrari);
        service.printQueue();
        service.performMaintenance();
        service.printQueue();

        Hypermarket ashan = new Hypermarket();
        ashan.addConsumer("Валерий");
        ashan.addConsumer("Аркадий");
        ashan.addConsumer("Леонид");
        ashan.addConsumer("Валентина");
        ashan.addConsumer("Оксана");
        ashan.addConsumer("Дмитрий");
        ashan.addConsumer("Олег");
        ashan.addConsumer("Семён");
        ashan.addConsumer("Дарья");
        ashan.addConsumer("Мария");
        ashan.addConsumer("Глеб");
        ashan.addConsumer("Иван");
        ashan.addConsumer("Даниил");
        ashan.addConsumer("Антон");
        ashan.addConsumer("Татьяна");
        ashan.addConsumer("Артём");
        ashan.printBoxOffices();


    }

//    void example() {
//        List<List<String>> biDemArrList = new ArrayList<>();
//        for (int i = 0; i < 8; i++) {
//            biDemArrList.add(i, new ArrayList<>());
//            for (int j = 0; j < 8; j++) {
//                biDemArrList.get(i).add(j, "◯");
//            }
//        }
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                System.out.print(biDemArrList.get(i).get(j) + " ");
//            }
//        }
//    }

    public static void checkDiagnosed(Transport... transports) {
        try {
            for (Transport a : transports) {
                if (!a.getDiagnosed()) throw new RuntimeException(a.getTypeOfTransport()+" "+a.getBrand()+" "+a.getModel()+" не прошел диагностику");
            }
        } catch (CantGetDiagnosed e) {
            System.out.println(e.getTransport()+" в диагностике не требуется");
        }
    }
}