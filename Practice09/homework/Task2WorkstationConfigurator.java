package semester1.practice09.homework;

import java.util.Arrays;
import java.util.Locale;

public class Task2WorkstationConfigurator {
    public static void main(String[] args) {
        System.out.println("================ КОНФІГУРАТОР РОБОЧОЇ СТАНЦІЇ (КОМПОЗИЦІЯ) ================");

        Motherboard board = new Motherboard("ASUS ROG B650", "AM5", 4);
        PowerSupplyUnit psu = new PowerSupplyUnit("Seasonics 750W Gold", 750, 0.90);
        WorkstationPC pc = new WorkstationPC("DeepLearning-Rig", board, psu);

        int[] samples = {7380, 7450, 7410, 7465};
        NvmeSsdDrive ssd = new NvmeSsdDrive("Samsung 990 Pro 2TB", 7500, 2000, 7450, samples);

        System.out.println("[ПЕРЕВІРКА СУМІСНОСТІ]:");
        pc.installComponent(new ProcessorUnit("Intel Core i9", 21000, "LGA1700", 24, 6.0, 253));
        pc.installComponent(new ProcessorUnit("AMD Ryzen 9 7950X", 24500, "AM5", 16, 5.7, 170));
        pc.installComponent(new GraphicsAccelerator("NVIDIA RTX 4080 Super", 46900, 16, 552, 320));
        pc.installComponent(ssd);
        pc.installComponent(new GraphicsAccelerator("NVIDIA RTX 4090", 89000, 24, 512, 450));

        System.out.println();
        System.out.println(pc);

        System.out.println();
        System.out.println("[ЗАХИСНЕ КОПІЮВАННЯ NvmeSsdDrive]:");
        samples[0] = 1;
        int[] copy = ssd.getSpeedSamples();
        copy[1] = 2;
        System.out.println("  Зовнішній масив змінено: " + Arrays.toString(samples));
        System.out.println("  Копія з геттера змінена: " + Arrays.toString(copy));
        System.out.println("  Всередині диска:         " + Arrays.toString(ssd.getSpeedSamples())
                + " (середня швидкість " + String.format(Locale.US, "%.1f", ssd.getAverageSampleSpeed()) + " МБ/с)");
        System.out.println("===========================================================================");
    }
}

class Motherboard {
    private final String model;
    private final String socketType;
    private final int maxExpansionSlots;

    public Motherboard(String model, String socketType, int maxExpansionSlots) {
        this.model = model;
        this.socketType = socketType;
        this.maxExpansionSlots = Math.max(1, Math.min(8, maxExpansionSlots));
    }

    public String getModel() {
        return model;
    }

    public String getSocketType() {
        return socketType;
    }

    public int getMaxExpansionSlots() {
        return maxExpansionSlots;
    }

    public boolean isSocketCompatible(String cpuSocket) {
        return cpuSocket != null && socketType.equalsIgnoreCase(cpuSocket);
    }
}

class PowerSupplyUnit {
    private final String model;
    private final int maxOutputWatts;
    private final double efficiencyCoefficient;

    public PowerSupplyUnit(String model, int maxOutputWatts, double efficiencyCoefficient) {
        this.model = model;
        this.maxOutputWatts = Math.max(0, maxOutputWatts);
        this.efficiencyCoefficient = Math.max(0.80, Math.min(0.96, efficiencyCoefficient));
    }

    public String getModel() {
        return model;
    }

    public double getEfficiencyCoefficient() {
        return efficiencyCoefficient;
    }

    public int getSafeContinuousWatts() {
        return (int) (maxOutputWatts * 0.85);
    }

    public double calculateWallPowerDraw(int internalLoadWatts) {
        return internalLoadWatts / efficiencyCoefficient;
    }
}

abstract class AbstractHardwareComponent {
    private final String modelName;
    private final double priceUah;

    public AbstractHardwareComponent(String modelName, double priceUah) {
        this.modelName = modelName;
        this.priceUah = Math.max(0, priceUah);
    }

    public String getModelName() {
        return modelName;
    }

    public double getPriceUah() {
        return priceUah;
    }

    public abstract int getPowerWatts();

    public abstract double getBenchmarkScore();

    public abstract String getCategory();

    @Override
    public String toString() {
        return String.format(Locale.US, "[%s] %s (%d Вт | Score: %.1f)",
                getCategory(), modelName, getPowerWatts(), getBenchmarkScore());
    }
}

class ProcessorUnit extends AbstractHardwareComponent {
    private final String socket;
    private final int cores;
    private final double boostClockGhz;
    private final int tdpWatts;

    public ProcessorUnit(String modelName, double priceUah, String socket, int cores, double boostClockGhz, int tdpWatts) {
        super(modelName, priceUah);
        this.socket = socket;
        this.cores = Math.max(1, cores);
        this.boostClockGhz = boostClockGhz;
        this.tdpWatts = tdpWatts;
    }

    public String getSocket() {
        return socket;
    }

    @Override
    public int getPowerWatts() {
        return tdpWatts;
    }

    @Override
    public double getBenchmarkScore() {
        return cores * boostClockGhz * 120.0;
    }

    @Override
    public String getCategory() {
        return "CPU";
    }
}

class GraphicsAccelerator extends AbstractHardwareComponent {
    private final int vramGb;
    private final int tensorCores;
    private final int boardPowerWatts;

    public GraphicsAccelerator(String modelName, double priceUah, int vramGb, int tensorCores, int boardPowerWatts) {
        super(modelName, priceUah);
        this.vramGb = vramGb;
        this.tensorCores = tensorCores;
        this.boardPowerWatts = boardPowerWatts;
    }

    @Override
    public int getPowerWatts() {
        return boardPowerWatts;
    }

    @Override
    public double getBenchmarkScore() {
        return vramGb * 250.0 + tensorCores * 1.5;
    }

    @Override
    public String getCategory() {
        return "GPU";
    }
}

class NvmeSsdDrive extends AbstractHardwareComponent {
    private final int capacityGb;
    private final int readSpeedMbSec;
    private final int[] speedSamples;

    public NvmeSsdDrive(String modelName, double priceUah, int capacityGb, int readSpeedMbSec, int[] speedSamples) {
        super(modelName, priceUah);
        this.capacityGb = capacityGb;
        this.readSpeedMbSec = readSpeedMbSec;
        this.speedSamples = (speedSamples == null) ? new int[0] : Arrays.copyOf(speedSamples, speedSamples.length);
    }

    public int[] getSpeedSamples() {
        return Arrays.copyOf(speedSamples, speedSamples.length);
    }

    public double getAverageSampleSpeed() {
        if (speedSamples.length == 0) {
            return 0;
        }
        double sum = 0;
        for (int s : speedSamples) {
            sum += s;
        }
        return sum / speedSamples.length;
    }

    @Override
    public int getPowerWatts() {
        return 12;
    }

    @Override
    public double getBenchmarkScore() {
        return readSpeedMbSec * 0.25;
    }

    @Override
    public String getCategory() {
        return "NVMe SSD";
    }
}

class WorkstationPC {
    private final String buildName;
    private final Motherboard motherboard;
    private final PowerSupplyUnit psu;
    private final AbstractHardwareComponent[] components;
    private int componentCount;

    public WorkstationPC(String buildName, Motherboard motherboard, PowerSupplyUnit psu) {
        this.buildName = buildName;
        this.motherboard = motherboard;
        this.psu = psu;
        this.components = new AbstractHardwareComponent[motherboard.getMaxExpansionSlots()];
    }

    public boolean installComponent(AbstractHardwareComponent comp) {
        if (comp == null) {
            System.out.println("❌ Відмова: порожній компонент!");
            return false;
        }
        if (componentCount >= motherboard.getMaxExpansionSlots()) {
            System.out.println("❌ Відмова: на платі " + motherboard.getModel() + " немає вільних слотів для " + comp.getModelName() + "!");
            return false;
        }
        if (comp.getCategory().equals("CPU")) {
            ProcessorUnit cpu = (ProcessorUnit) comp;
            if (!motherboard.isSocketCompatible(cpu.getSocket())) {
                System.out.println("❌ Відмова: Процесор " + cpu.getModelName() + " (" + cpu.getSocket() + ") несумісний із платою "
                        + motherboard.getModel() + " (Сокет " + motherboard.getSocketType() + ")!");
                return false;
            }
        }
        int newTotal = getTotalPowerWatts() + comp.getPowerWatts();
        if (newTotal > psu.getSafeContinuousWatts()) {
            System.out.println("❌ Відмова: " + comp.getModelName() + " (" + comp.getPowerWatts() + " Вт) підніме споживання до "
                    + newTotal + " Вт при безпечному ліміті БЖ " + psu.getSafeContinuousWatts() + " Вт! Ризик перевантаження!");
            return false;
        }
        components[componentCount++] = comp;
        System.out.println("✅ Встановлено: " + comp);
        return true;
    }

    public int getTotalPowerWatts() {
        int sum = 0;
        for (int i = 0; i < componentCount; i++) {
            sum += components[i].getPowerWatts();
        }
        return sum;
    }

    public double getTotalSystemScore() {
        double sum = 0;
        for (int i = 0; i < componentCount; i++) {
            sum += components[i].getBenchmarkScore();
        }
        return sum;
    }

    public double getTotalBuildPrice() {
        double sum = 0;
        for (int i = 0; i < componentCount; i++) {
            sum += components[i].getPriceUah();
        }
        return sum;
    }

    @Override
    public String toString() {
        int load = getTotalPowerWatts();
        String s = "[ПАСПОРТ ЗБІРКИ '" + buildName + "']:\n";
        s += "  Материнська плата: " + motherboard.getModel() + " (Socket: " + motherboard.getSocketType()
                + ", Слотів: " + componentCount + "/" + motherboard.getMaxExpansionSlots() + ")\n";
        s += String.format(Locale.US, "  Блок живлення:     %s (Безпечний ліміт 85%%: %d Вт, ККД: %.0f%%)%n",
                psu.getModel(), psu.getSafeContinuousWatts(), psu.getEfficiencyCoefficient() * 100);
        for (int i = 0; i < componentCount; i++) {
            s += "    " + (i + 1) + ". " + components[i] + "\n";
        }
        s += String.format(Locale.US, "  Внутрішнє споживання: %d Вт (З розетки з урахуванням ККД: %.2f Вт) -> %s%n",
                load, psu.calculateWallPowerDraw(load), load <= psu.getSafeContinuousWatts() ? "СТАБІЛЬНО!" : "ПЕРЕВАНТАЖЕННЯ!");
        s += String.format(Locale.US, "  Сумарний індекс продуктивності: %.2f балів%n", getTotalSystemScore());
        s += String.format(Locale.US, "  Загальна вартість конфігурації: %.2f грн", getTotalBuildPrice());
        return s;
    }
}
