package Parkeersimulator.View;

import Parkeersimulator.Model.Car;
import Parkeersimulator.Model.Location;
import Parkeersimulator.Model.Simulator;

import java.awt.*;

public class CarParkView extends AbstractView {

    private Dimension size;
    private Image carParkImage;

    public CarParkView(Simulator simulator)
    {
        super(simulator);
        size = new Dimension(0, 0);

    }



        /**
         * Overridden. Tell the GUI manager how big we would like to be.
         */
        public Dimension getPreferredSize() {
            return new Dimension(800, 500);
        }

        /**
         * Overriden. The car park view component needs to be redisplayed. Copy the
         * internal image to screen.
         */
        public void paintComponent(Graphics g) {
            // Create a new car park image if the size has changed.
            if (!size.equals(getSize())) {
                size = getSize();
                carParkImage = createImage(size.width, size.height);
            }

            Graphics graphics = carParkImage.getGraphics();
            for(int floor = 0; floor < getModel().getParkeerGarage().getNumberOfFloors(); floor++) {
                for(int row = 0; row < getModel().getParkeerGarage().getNumberOfRows(); row++) {
                    for(int place = 0; place < getModel().getParkeerGarage().getNumberOfPlaces(); place++) {
                        Location location = new Location(floor, row, place);
                        Car car = getModel().getParkeerGarage().getCarAt(location);
                        Color color = car == null ? Color.white : car.getColor();
                        drawPlace(graphics, location, color);
                    }
                }
            }

            if (carParkImage == null) {
                return;
            }

            Dimension currentSize = getSize();
            if (size.equals(currentSize)) {
                g.drawImage(carParkImage, 0, 0, null);
            }
            else {
                // Rescale the previous image.
                g.drawImage(carParkImage, 0, 0, currentSize.width, currentSize.height, null);
            }
        }


        /**
         * Paint a place on this car park view in a given color.
         */
        private void drawPlace(Graphics graphics, Location location, Color color) {
            graphics.setColor(color);
            graphics.fillRect(
                    location.getFloor() * 260 + (1 + (int)Math.floor(location.getRow() * 0.5)) * 75 + (location.getRow() % 2) * 20,
                    60 + location.getPlace() * 10,
                    20 - 1,
                    10 - 1); // TODO use dynamic size or constants
        }
    }




