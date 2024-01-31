import React, { useEffect, useState } from "react";
import { Button, Form } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import arrayt from "./arraytheme";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";

function Edit() {
    const [image, setImage] = useState("");
    const [themeName, setThemeName] = useState("");
    const [themePrice, setThemePrice] = useState("");
    const [themeDetails, setThemeDetails] = useState("");
    const [id, setID] = useState("");

    let history = useNavigate();

    useEffect(() => {
        const storedID = localStorage.getItem("id");
        const storedThemeName = localStorage.getItem("Theme Name");
        const storedThemePrice = localStorage.getItem("Theme Price");
        const storedThemeDetails = localStorage.getItem("Theme Details");
        const storedImage = localStorage.getItem("Image");
    
        setID(storedID || "");
        setThemeName(storedThemeName || "");
        setThemePrice(storedThemePrice || "");
        setThemeDetails(storedThemeDetails || "");
        setImage(storedImage||"");
    
    }, []);
    

    const handleImageChange = (e) => {
        const file = e.target.files[0];
        if (file) {
            setImage(URL.createObjectURL(file));
        }
    };

    const handleSubmit = (e) => {
        e.preventDefault();
    
        let index = arrayt.findIndex(item => item.id === id);
        let item = arrayt[index];
    
        item["Theme Name"] = themeName;
        item["Theme Price"] = themePrice;
        item["Theme Details"] = themeDetails;
    
        if (image !== "") {
            item.Image = image;
        }
    
        history("/themehome");
    };
    

    return (
        <div>
            <Form className="d-grid gap-2" style={{ margin: "5rem" }}>
                <Form.Group className="mb-3">
                    <Form.Label>Image</Form.Label>
                    <Form.Control type="file" onChange={handleImageChange} />
                </Form.Group>

                <Form.Label>Theme Name</Form.Label>
                <Form.Group className="mb-3">
                    <Form.Control value={themeName} onChange={(e) => setThemeName(e.target.value)} type="text" placeholder="Theme Name" required />
                </Form.Group>
                <Form.Label>Theme Price</Form.Label>
                <Form.Group className="mb-3">
                    <Form.Control value={themePrice} onChange={(e) => setThemePrice(e.target.value)} type="number" placeholder="Theme Price" required />
                </Form.Group>
                <Form.Label>Theme Details</Form.Label>
                <Form.Group className="mb-3">
                    <Form.Control value={themeDetails} onChange={(e) => setThemeDetails(e.target.value)} type="text" placeholder="Theme Details" required />
                </Form.Group>
                <Button onClick={(e) => handleSubmit(e)} variant="primary" type="submit" size="lg">
                    Update
                </Button>
                <Link className="d-grid gap-2" to="/themehome">
                    <Button variant="warning" size="lg">
                        Home
                    </Button>
                </Link>
            </Form>
        </div>
    );
}

export default Edit;