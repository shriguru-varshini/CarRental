import React, { useState } from "react";
import carService from "../../service/carService";

const AddCar = () => {
  const [car, setCar] = useState({
    brand: "",
    model: "",
    year: "", // Keep it as a string for controlled input
    type: "Sedan",
    pricePerHour: "", // Maintain consistent types
    pricePerDay: "",
    pricePerWeek: "",
    fuelType: "Petrol",
    transmission: "Manual",
    availability: true,
  });

  const handleChange = (e) => {
    const { name, value } = e.target;

    // Convert numeric values properly
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

    console.log("Sending car data:", car);

    try {
      await carService.addCar(car);
      alert("Car added successfully!");
      setCar({
        brand: "",
        model: "",
        year: "",
        type: "Sedan",
        pricePerHour: "",
        pricePerDay: "",
        pricePerWeek: "",
        fuelType: "Petrol",
        transmission: "Manual",
        availability: true,
      });
    } catch (error) {
      console.error("Error adding car:", error.response?.data || error.message);
      alert("Failed to add car. Check console for details.");
    }
  };

  return (
    <div>
      <h2>Add a Car</h2>
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

        <button type="submit">Add Car</button>
      </form>
    </div>
  );
};

export default AddCar;
