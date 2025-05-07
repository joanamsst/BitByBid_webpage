export function initParticles() {
    tsParticles.load("tsparticles", {
        fullScreen: { enable: false }, // já está no body
        background: {
            color: "transparent"
        },
        particles: {
            number: {
                value: 200,
                density: { enable: true, value_area: 800 }
            },
            color: {
                value: ["#ED2B68", "#47aaca", "#86b139"]
            },
            shape: {
                type: "circle"
            },
            opacity: {
                value: 0.3
            },
            size: {
                value: { min: 1, max: 4 }
            },
            move: {
                enable: true,
                speed: 1,
                direction: "none",
                random: false,
                straight: false
            },
            links: {
                enable: true,
                distance: 100,
                color: "#ffffff",
                opacity: 0.1,
                width: 1
            }
        },
        interactivity: {
            events: {
                onhover: {
                    enable: true,
                    mode: "repulse"
                }
            },
            modes: {
                repulse: {
                    distance: 70
                }
            }
        },
        retina_detect: true
    });
}
