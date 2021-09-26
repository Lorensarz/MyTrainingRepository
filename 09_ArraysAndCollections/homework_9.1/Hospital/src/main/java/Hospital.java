public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //Напишите код метода generatePatientsTemperatures(), который должен сгенерировать массив float,
        // содержащий значения температур пациентов от 32 до 40 градусов.


        float[] patientsTemperatures = new float[patientsCount];
        for (int i = 0; i < patientsTemperatures.length; i++) {
            patientsTemperatures[i] = 42 + (float) (32 * Math.random());
        }
        return patientsTemperatures;
    }


    //TODO: напишите метод генерации массива температур пациентов


    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.

        */

        String patientsTemperatures = "";
        float averageTemperature = 0;
        int countHealthyPatients = 0;

        for (float patients : temperatureData) {
            patientsTemperatures += String.format("%.1f", patients) + " ";
            averageTemperature += patients;
            if (patients >= 36.2F && patients <= 36.9F)
                countHealthyPatients++;
        }


        String report = "Температуры пациентов: " + patientsTemperatures +
                        "\nСредняя температура: " +
                String.format("%.2f", (averageTemperature / temperatureData.length)) +
                        "\nКоличество здоровых: " + countHealthyPatients;

        return report;
    }
}
