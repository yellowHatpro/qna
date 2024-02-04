/** @type {import('next').NextConfig} */
const nextConfig = {
    images: {
        remotePatterns: [
            {hostname: "avatars.githubusercontent.com"}
        ],
    },
    experimental : {
        serverActions: true,
    },
};

module.exports = nextConfig
