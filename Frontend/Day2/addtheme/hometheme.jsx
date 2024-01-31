import React, { useState } from "react";
import { Button } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import arrayt from "./arraytheme";
import { Link, useNavigate } from "react-router-dom";
import './hometheme.css';

function Home() {
    const [id, setID] = useState("");
    const [themeName, setThemeName] = useState("");
    const [themePrice, setThemePrice] = useState("");
    const [image, setImage] = useState("");
    const [themeDetails, setThemeDetails] = useState("");

    let navigate = useNavigate();

    function setItemDetails(id, themeName, themePrice, image, themeDetails) {
        localStorage.setItem("id", id);
        localStorage.setItem("Theme Name", themeName);
        localStorage.setItem("Theme Price", themePrice);
        localStorage.setItem("Theme Details", themeDetails);

        setID(id);
        setThemeName(themeName);
        setThemePrice(themePrice);
        setThemeDetails(themeDetails);

        if (image !== "") {
            setImage(image);
        }
    }

    function deleted(id) {
        let index = arrayt.findIndex((item) => item.id === id);
        arrayt.splice(index, 1);
        navigate("/themehome");
    }

    return (
        <div className="updated-classname">
            <br/><br/>
            <div className="updated-grid-container">
                {arrayt.map((item) => (
                    <div key={item.id} className="updated-grid-item">
                        <img
                            src={item.Image}
                            className="updated-dis"
                        />
                        <div className="updated-gift-name"><i className="fa fa-gift"></i>{item["Theme Name"]}</div>
                        <div className="updated-price"><i className="fa fa-inr"></i>{item["Theme Price"]}</div>
                        <div className="updated-quantity"><i className="fas fa-sort-amount-up"></i> {item["Theme Details"]}</div><br/>
                        <div className="updated-buttons">
                            <Link to="/themeedit" className="updated-edit-link">
                                <Button className="updated-edit-button"
                                    onClick={(e) =>
                                        setItemDetails(
                                            item.id,
                                            item["Theme Name"],
                                            item["Theme Price"],
                                            item.Image,
                                            item["Theme Details"]
                                        )
                                    }
                                    variant="info"
                                >
                                    Edit
                                </Button>
                            </Link>
                            <Button className="updated-delete-button"
                                onClick={(e) => deleted(item.id)}
                                variant="danger"
                            >
                                Delete
                            </Button>
                        </div>
                    </div>
                ))}
            </div>
            <Link  to="/themecreate">
                <Button className="updated-create-button" variant="warning" size="lg">
                    Create
                </Button>
            </Link>
        </div>
    );
}

export default Home;