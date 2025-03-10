import React, { useState } from "react";
import carService from "../../service/carService";

const UpdateCar = () => {
  const [carId, setCarId] = useState("");
  const [car, setCar] = useState(null);
  const [loading, setLoading] = useState(false);

  const handleFetchCar = async () => {
    if (!carId) {
      alert("Please enter a valid car ID.");
      return;
    }

    setLoading(true);
    try {
      const fetchedCar = await carService.getCarById(carId);
      if (!fetchedCar) {
        alert("Car not found!");
        setCar(null);
      } else {
        setCar(fetchedCar);
      }
    } catch (error) {
      console.error("Error fetching car:", error.response?.data || error.message);
      alert("Failed to fetch car.");
    }
    setLoading(false);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    const newValue =
      name === "year" || name.includes("price")
        ? value === "" ? "" : parseFloat(value)
        : value;

    setCar((prevCar) => ({
      ...prevCar,
      [name]: newValue,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!car) {
      alert("No car data to update.");
      return;
    }

    try {
      await carService.updateCar(carId, car);
      alert("Car updated successfully!");
    } catch (error) {
      console.error("Error updating car:", error.response?.data || error.message);
      alert("Failed to update car.");
    }
  };

  return (
    <div>
      <h2>Update Car</h2>
      
      <div>
        <label>Enter Car ID:</label>
        <input
          type="number"
          value={carId}
          onChange={(e) => setCarId(e.target.value)}
          placeholder="Car ID"
          required
        />
        <button onClick={handleFetchCar} disabled={loading}>
          {loading ? "Fetching..." : "Fetch Car"}
        </button>
      </div>

      {car && (
        <form onSubmit={handleSubmit}>
          <input type="text" name="brand" value={car.brand} onChange={handleChange} placeholder="Brand" required />
          <input type="text" name="model" value={car.model} onChange={handleChange} placeholder="Model" required />
          <input type="number" name="year" value={car.year} onChange={handleChange} placeholder="Year" required />

          <div>
            <label>Type:</label>
            {["Sedan", "SUV", "TwoWheeler", "Convertible", "Truck"].map((option) => (
              <label key={option}>
                <input type="radio" name="type" value={option} checked={car.type === option} onChange={handleChange} />
                {option}
              </label>
            ))}
          </div>

          <input type="number" name="pricePerHour" value={car.pricePerHour} onChange={handleChange} placeholder="Price per Hour" required />
          <input type="number" name="pricePerDay" value={car.pricePerDay} onChange={handleChange} placeholder="Price per Day" required />
          <input type="number" name="pricePerWeek" value={car.pricePerWeek} onChange={handleChange} placeholder="Price per Week" required />

          <div>
            <label>Fuel Type:</label>
            {["Petrol", "Diesel", "Electric", "Hybrid"].map((option) => (
              <label key={option}>
                <input type="radio" name="fuelType" value={option} checked={car.fuelType === option} onChange={handleChange} />
                {option}
              </label>
            ))}
          </div>

          <div>
            <label>Transmission:</label>
            {["Manual", "Automatic"].map((option) => (
              <label key={option}>
                <input type="radio" name="transmission" value={option} checked={car.transmission === option} onChange={handleChange} />
                {option}
              </label>
            ))}
          </div>

          <button type="submit">Update Car</button>
        </form>
      )}
    </div>
  );
};

export default UpdateCar;
